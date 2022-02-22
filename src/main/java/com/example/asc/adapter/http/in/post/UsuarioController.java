package com.example.asc.adapter.http.in.post;

import com.example.asc.adapter.http.dto.entrada.UsuarioDtoEntrada;
import com.example.asc.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

/*    @Autowired
    private UsuarioMapper usuarioMapper;*/

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDtoEntrada usuarioDtoEntrada){
        System.out.println();
        return ResponseEntity.ok("Teste");
    }
}
