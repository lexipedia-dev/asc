package com.example.asc.adapter.http.in.testes;

import com.example.asc.adapter.http.dto.entrada.UsuarioDtoEntrada;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestesController {

    @PostMapping("/teste-post")
    public ResponseEntity<?> testePost(@RequestBody UsuarioDtoEntrada usuarioDtoEntrada){
        System.out.println();
        return ResponseEntity.ok("Teste Post");
    }

    @GetMapping("/teste-get")
    public ResponseEntity<?> testGet(@RequestBody UsuarioDtoEntrada usuarioDtoEntrada){
        System.out.println();
        return ResponseEntity.ok("Teste LALALALALALALALALLAA");
    }

    @PutMapping("/teste-put")
    public ResponseEntity<?> testPut(@RequestBody UsuarioDtoEntrada usuarioDtoEntrada){
        System.out.println();
        return ResponseEntity.ok("Teste Put");
    }

    @PatchMapping("/teste-patch")
    public ResponseEntity<?> testPatch(@RequestBody UsuarioDtoEntrada usuarioDtoEntrada){
        System.out.println();
        return ResponseEntity.ok("Teste Patch");
    }

    @DeleteMapping("/teste-delete")
    public ResponseEntity<?> testDelete(@RequestBody UsuarioDtoEntrada usuarioDtoEntrada){
        System.out.println();
        return ResponseEntity.ok("Teste Delete");
    }
}
