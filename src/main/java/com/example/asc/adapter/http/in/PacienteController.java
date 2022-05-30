package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.PacienteRepository;
import com.example.asc.core.domain.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<?> buscarPacientes(@Param("nome")String nome,
                                             @Param("sus")String sus,
                                             @Param("cpf")String cpf,
                                             @Param("telefone")String telefone,
                                             @Param("endereco")String endereco,
                                             @Param("numeroCasa")String numeroCasa,
                                             @Param("bairro")String bairro,
                                             @Param("temPatologia")String temPatologia,
                                             @Param("necessitaVisitaMedica")String necessitaVisitaMedica,
                                             @Param("tomaRemedioControlado")String tomaRemedioControlado,
                                             @Param("temDependente")String temDependente,
                                             @Param("fuma")String fuma,
                                             @Param("bebe")String bebe,
                                             @Param("idoso")String idoso,
                                             @Param("cancer")String cancer,
                                             @Param("filhos")String filhos,
                                             @Param("rg")String rg
                                             ){

        if(nome == null &&
                sus == null &&
                cpf == null &&
                telefone == null &&
                endereco == null &&
                numeroCasa == null &&
                bairro == null &&
                temPatologia == null &&
                necessitaVisitaMedica == null &&
                tomaRemedioControlado == null &&
                temDependente == null &&
                fuma == null &&
                bebe == null &&
                idoso == null &&
                cancer == null &&
                filhos == null &&
                rg == null
        ){

            return ResponseEntity.ok().body(pacienteRepository.findAll());
        }
        List<String> parametros = new ArrayList<>();
        List<String> valores = new ArrayList<>();
        if(nome!=null){
            parametros.add("nome");
            valores.add(nome);
        }
        if(sus!=null){
            parametros.add("sus");
            valores.add(sus);
        }
        if(cpf!=null){
            parametros.add("cpf");
            valores.add(cpf);
        }
        if(telefone!=null){
            parametros.add("telefone");
            valores.add(telefone);
        }
        if(endereco!=null){
            parametros.add("endereco");
            valores.add(endereco);
        }
        if(numeroCasa!=null){
            parametros.add("numeroCasa");
            valores.add(numeroCasa);
        }
        if(bairro!=null){
            parametros.add("bairro");
            valores.add(bairro);
        }
        if(temPatologia!=null){
            parametros.add("temPatologia");
            valores.add(temPatologia);
        }
        if(necessitaVisitaMedica!=null){
            parametros.add("necessitaVisitaMedica");
            valores.add(necessitaVisitaMedica);
        }
        if(tomaRemedioControlado!=null){
            parametros.add("tomaRemedioControlado");
            valores.add(tomaRemedioControlado);
        }
        if(temDependente!=null){
            parametros.add("temDependente");
            valores.add(temDependente);
        }
        if(fuma!=null){
            parametros.add("fuma");
            valores.add(fuma);
        }
        if(bebe!=null){
            parametros.add("bebe");
            valores.add(bebe);
        }
        if(idoso!=null){
            parametros.add("idoso");
            valores.add(idoso);
        }
        if(cancer!=null){
            parametros.add("cancer");
            valores.add(cancer);
        }
        if(filhos!=null){
            parametros.add("filhos");
            valores.add(filhos);
        }
        if(rg!=null){
            parametros.add("rg");
            valores.add(rg);
        }

        List<Object> response;
        if(parametros.size() == 1 && valores.size() == 1){
            response = pacienteRepository.findByQuery("Paciente", parametros.get(0), valores.get(0));
        }else {
            response = pacienteRepository.findByQuery("Paciente", parametros, valores);
        }
        return ResponseEntity.ok().body(response);
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
