package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.PatologiaRepository;
import com.example.asc.core.domain.Patologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patologia")
public class PatologiaController {

    @Autowired
    private PatologiaRepository patologiaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarPatologia(@RequestBody Patologia patologia){
        patologiaRepository.save(patologia);
        return ResponseEntity.ok("Patologia cadastrada");
    }

    @GetMapping
    public ResponseEntity<?> buscarPatologias(){
        return ResponseEntity.ok().body(patologiaRepository.findAll());
    }

    @GetMapping("/{idPatologia}")
    public ResponseEntity<?> buscarPatologia(@PathVariable("idPatologia")Integer idPatologia){
        return ResponseEntity.ok().body(patologiaRepository.findById(idPatologia).get());
    }

    @PutMapping("/{idPatologia}")
    public ResponseEntity<?> alterarPatologia(@PathVariable("idPatologia")Integer idPatologia,
                                              @RequestBody Patologia patologiaAtualizada){
        Patologia patologiaAtual = patologiaRepository.findById(idPatologia).get();
        patologiaAtual.setNome(patologiaAtualizada.getNome());
        patologiaRepository.save(patologiaAtual);
        return ResponseEntity.ok().body("Patologia atualizada");
    }

    @DeleteMapping("/{idPatologia}")
    public ResponseEntity<?> deletarPatologia(@PathVariable("idPatologia")Integer idPatologia){
        patologiaRepository.deleteById(idPatologia);
        return ResponseEntity.ok().body("Patologia deletada");
    }
}
