package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.dto.entrada.LoginDtoIn;
import com.example.asc.adapter.http.dto.saida.TokenDtoOut;
import com.example.asc.adapter.http.repositories.UsuarioRepository;
import com.example.asc.core.domain.Usuario;
import com.example.asc.core.ports.AutenticacaoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AutenticacaoUseCase autenticacaoUseCase;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDtoIn form){
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(form.getEmail());
        if(!optionalUsuario.isPresent()){
            return ResponseEntity.notFound().build();
        }

        try {
            TokenDtoOut tokenDtoOut = new TokenDtoOut(autenticacaoUseCase.autenticar(form), "Bearer");
            return ResponseEntity.ok(tokenDtoOut);
        } catch (AuthenticationException ex){
            return ResponseEntity.badRequest().build();
        }


    }
}
