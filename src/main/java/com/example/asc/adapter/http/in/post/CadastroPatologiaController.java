package com.example.asc.adapter.http.in.post;

import com.example.asc.core.domain.Patologia;
import com.example.asc.core.repositories.PatologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patologia")
public class CadastroPatologiaController {

    @Autowired
    private PatologiaRepository patologiaRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarPatologia(@RequestBody Patologia patologia){
        patologiaRepository.save(patologia);
        return ResponseEntity.ok("Patologia cadastrada");
    }
}
