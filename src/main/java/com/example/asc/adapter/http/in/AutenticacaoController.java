package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.dto.entrada.LoginDtoIn;
import com.example.asc.adapter.http.dto.saida.TokenDtoOut;
import com.example.asc.adapter.http.repositories.UsuarioRepository;
import com.example.asc.config.security.TokenServiceAsc;
import com.example.asc.core.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServiceAsc tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDtoIn form){
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(form.getEmail());
        if(!optionalUsuario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        UsernamePasswordAuthenticationToken dadosLogin = form.gerarDadosLogin();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            System.out.println(token);
            return ResponseEntity.ok(new TokenDtoOut(token, "Bearer"));
        } catch (AuthenticationException ex){
            return ResponseEntity.badRequest().build();
        }


    }
}
