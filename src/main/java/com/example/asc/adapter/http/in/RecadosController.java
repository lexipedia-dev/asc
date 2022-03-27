package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.RecadoRepository;
import com.example.asc.core.domain.Paciente;
import com.example.asc.core.domain.Recado;
import com.example.asc.core.domain.Usuario;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recado")
public class RecadosController {

    @Autowired
    private RecadoRepository recadoRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarRecado(@RequestBody Recado recado,
                                             @AuthenticationPrincipal Usuario usuario){
        recado.setUsuario(usuario);
        recadoRepository.save(recado);
        return ResponseEntity.ok("Recado cadastrado");
    }

    @GetMapping
    public ResponseEntity<?> buscarRecados(){
        return ResponseEntity.ok().body(recadoRepository.findAll());
    }

    @GetMapping("/{idRecado}")
    public ResponseEntity<?> buscarPaciente(@PathVariable("idRecado")Integer idRecado){
        return ResponseEntity.ok().body(recadoRepository.findById(idRecado).get());
    }

    @PutMapping("/{idRecado}")
    public ResponseEntity<?> alterarPaciente(@PathVariable("idRecado")Integer idRecado,
                                             @RequestBody Recado recadoAtualizado,
                                             @AuthenticationPrincipal Usuario usuario){
        Recado recadoAtual = recadoRepository.findById(idRecado).get();
        recadoAtual.setUsuario(usuario);
        recadoAtual.setNome(recadoAtualizado.getNome());
        recadoAtual.setSus(recadoAtualizado.getSus());
        recadoAtual.setDataNascimento(recadoAtualizado.getDataNascimento());
        recadoAtual.setEndereco(recadoAtualizado.getEndereco());
        recadoAtual.setNumero(recadoAtualizado.getNumero());
        recadoAtual.setBairro(recadoAtualizado.getBairro());
        recadoAtual.setRecado(recadoAtualizado.getRecado());

        recadoRepository.save(recadoAtual);
        return ResponseEntity.ok().body("Recado atualizado");
    }

    @DeleteMapping("/{idRecado}")
    public ResponseEntity<?> deletarPaciente(@PathVariable("idRecado")Integer idRecado){
        recadoRepository.deleteById(idRecado);
        return ResponseEntity.ok().body("Recado deletado");
    }
}
