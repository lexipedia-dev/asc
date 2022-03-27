package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.FamiliaRepository;
import com.example.asc.adapter.http.repositories.MembroFamiliaRepository;
import com.example.asc.core.domain.Familia;
import com.example.asc.core.domain.MembroFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membro-familia")
public class MembroFamiliaController {

    @Autowired
    private MembroFamiliaRepository membroFamiliaRepository;

    @Autowired
    private FamiliaRepository familiaRepository;

    @PostMapping("/{idFamilia}")
    public ResponseEntity<?> cadastrarMembroFamilia(@RequestBody MembroFamilia membroFamilia,
                                                    @PathVariable("idFamilia") Integer idFamilia){
        Familia familia = familiaRepository.findById(idFamilia).get();
        membroFamilia.setFamilia(familia);
        membroFamiliaRepository.save(membroFamilia);
        return ResponseEntity.ok().body("Membro da familia cadastrado");
    }

    @GetMapping("/{idMembroFamilia}")
    public ResponseEntity<?> buscarMembroFamilia(@PathVariable("idMembroFamilia") Integer idMembroFamilia){
        return ResponseEntity.ok().body(
                membroFamiliaRepository.findById(idMembroFamilia).get());
    }

    @DeleteMapping("/{idMembroFamilia}")
    public ResponseEntity<?> deletarMembroFamilia(@PathVariable("idMembroFamilia") Integer idMembroFamilia){
        membroFamiliaRepository.deleteById(idMembroFamilia);
        return ResponseEntity.ok().body("Membro da familia deletado");
    }

    @PutMapping("/{idMembroFamilia}")
    public ResponseEntity<?> alterarMembroFamilia(@PathVariable("idMembroFamilia") Integer idMembroFamilia,
                                                  @RequestBody MembroFamilia membroFamiliaAtualizado){
        MembroFamilia membroFamiliaAtual = membroFamiliaRepository.findById(idMembroFamilia).get();
        membroFamiliaAtual.setNome(membroFamiliaAtualizado.getNome());
        membroFamiliaAtual.setDataNascimento(membroFamiliaAtualizado.getDataNascimento());
        membroFamiliaAtual.setSus(membroFamiliaAtualizado.getSus());
        membroFamiliaRepository.save(membroFamiliaAtual);
        return ResponseEntity.ok().body("Membor da familia alterado");
    }
}
