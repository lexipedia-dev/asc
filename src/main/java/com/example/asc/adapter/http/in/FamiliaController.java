package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.FamiliaRepository;
import com.example.asc.adapter.http.repositories.MembroFamiliaRepository;
import com.example.asc.core.domain.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private MembroFamiliaRepository membroFamiliaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarFamilia(@RequestBody Familia familia){
        familiaRepository.save(familia);
        return ResponseEntity.ok("Familia cadastrada");
    }

    @GetMapping
    public ResponseEntity<?>buscarFamilias(){
        return ResponseEntity.ok().body(familiaRepository.findAll());
    }

    @GetMapping("/{idFamilia}")
    public ResponseEntity<?> buscarFamilia(@PathVariable("idFamilia") Integer idFamilia){
        Familia familia = familiaRepository.findById(idFamilia).get();
        return ResponseEntity.ok().body(familia);
    }

    @PutMapping("/{idFamilia}")
    public ResponseEntity<?> atualizarFamilia(@PathVariable("idFamilia") Integer idFamilia,
                                              @RequestBody Familia familiaAtualizada){
        Familia familiaAtual  = familiaRepository.findById(idFamilia).get();
        familiaAtual.setEndereco(familiaAtualizada.getEndereco());
        familiaAtual.setNumero(familiaAtualizada.getNumero());
        familiaAtual.setBairro(familiaAtualizada.getBairro());
        familiaAtual.setSus(familiaAtualizada.getSus());
        familiaAtual.setCpf(familiaAtualizada.getCpf());
        familiaAtual.setNomeResponsavel(familiaAtualizada.getNomeResponsavel());
        familiaRepository.save(familiaAtual);
        return ResponseEntity.ok().body("Familia atualizada");
    }

    @DeleteMapping("/{idFamilia}")
    public ResponseEntity<?> deletarFamilia(@PathVariable("idFamilia") Integer idFamilia){
        familiaRepository.deleteById(idFamilia);
        return ResponseEntity.ok().body("Familia deletada");
    }

}
