package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.PacienteRepository;
import com.example.asc.core.domain.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarPaciente(@RequestBody Paciente paciente){
        pacienteRepository.save(paciente);
        return ResponseEntity.ok("Paciente cadastrada");
    }

    @GetMapping
    public ResponseEntity<?> buscarPacientes(){
        return ResponseEntity.ok().body(pacienteRepository.findAll());
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<?> buscarPaciente(@PathVariable("idPaciente")Integer idPaciente){
        return ResponseEntity.ok().body(pacienteRepository.findById(idPaciente).get());
    }

    @PutMapping("/{idPaciente}")
    public ResponseEntity<?> alterarPaciente(@PathVariable("idPaciente")Integer idPaciente,
                                              @RequestBody Paciente pacienteAtualizado){
        Paciente pacienteAtual = pacienteRepository.findById(idPaciente).get();
        pacienteAtual.setNome(pacienteAtualizado.getNome());
        pacienteAtual.setSus(pacienteAtualizado.getSus());
        pacienteAtual.setCpf(pacienteAtualizado.getCpf());
        pacienteAtual.setTelefone(pacienteAtualizado.getTelefone());
        pacienteAtual.setEndereco(pacienteAtualizado.getEndereco());
        pacienteAtual.setNumeroCasa(pacienteAtualizado.getNumeroCasa());
        pacienteAtual.setBairro(pacienteAtualizado.getBairro());
        pacienteAtual.setTemPatologia(pacienteAtualizado.getTemPatologia());
        pacienteAtual.setNecessitaVisitaMedica(pacienteAtualizado.getNecessitaVisitaMedica());
        pacienteAtual.setTemDependente(pacienteAtualizado.getTemDependente());
        pacienteAtual.setFuma(pacienteAtualizado.getFuma());
        pacienteAtual.setBebe(pacienteAtualizado.getBebe());
        pacienteAtual.setIdoso(pacienteAtualizado.getIdoso());
        pacienteAtual.setCancer(pacienteAtualizado.getCancer());
        pacienteAtual.setFilhos(pacienteAtualizado.getFilhos());
        pacienteAtual.setRg(pacienteAtualizado.getRg());
        pacienteRepository.save(pacienteAtual);
        return ResponseEntity.ok().body("Patologia atualizada");
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<?> deletarPaciente(@PathVariable("idPaciente")Integer idPaciente){
        pacienteRepository.deleteById(idPaciente);
        return ResponseEntity.ok().body("Patologia deletada");
    }
}
