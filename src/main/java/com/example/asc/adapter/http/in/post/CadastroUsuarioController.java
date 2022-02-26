package com.example.asc.adapter.http.in.post;

import com.example.asc.core.domain.Usuario;
import com.example.asc.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class CadastroUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario){
        usuario.encryptPassword();
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado");
    }
}
