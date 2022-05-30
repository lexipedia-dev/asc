package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.FamiliaRepository;
import com.example.asc.adapter.http.repositories.MembroFamiliaRepository;
import com.example.asc.core.domain.Familia;
import com.example.asc.core.domain.Recado;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private MembroFamiliaRepository membroFamiliaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarFamilia(@RequestBody Familia familia) {
        familiaRepository.save(familia);
        return ResponseEntity.ok("Familia cadastrada");
    }

    @GetMapping
    public ResponseEntity<?> buscarFamilias(@Param("endereco") String endereco,
                                            @Param("numero") String numero,
                                            @Param("bairro") String bairro,
                                            @Param("sus") String sus,
                                            @Param("cpf") String cpf,
                                            @Param("nomeResponsavel") String nomeResponsavel
                                            ) {
        if(endereco == null &&
                numero == null &&
                bairro == null &&
                sus == null &&
                cpf == null &&
                nomeResponsavel == null
        ){
            return ResponseEntity.ok().body(familiaRepository.findAll());
        }
        List<String> parametros = new ArrayList<>();
        List<String> valores = new ArrayList<>();
        if(endereco != null){
            parametros.add("endereco");
            valores.add(endereco);
        }
        if(numero != null){
            parametros.add("numero");
            valores.add(numero);
        }
        if(bairro != null){
            parametros.add("bairro");
            valores.add(bairro);
        }
        if(sus != null){
            parametros.add("sus");
            valores.add(sus);
        }
        if(cpf != null){
            parametros.add("cpf");
            valores.add(cpf);
        }
        if(nomeResponsavel != null){
            parametros.add("nomeResponsavel");
            valores.add(nomeResponsavel);
        }
        List<Object> response;
        if(parametros.size() == 1 && valores.size() == 1){
            response = familiaRepository.findByQuery("Familia", parametros.get(0), valores.get(0));
        }else {
            response = familiaRepository.findByQuery("Familia", parametros, valores);
        }
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{idFamilia}")
    public ResponseEntity<?> buscarFamilia(@PathVariable("idFamilia") Integer idFamilia) {
        Familia familia = familiaRepository.findById(idFamilia).get();
        return ResponseEntity.ok().body(familia);
    }

    @PutMapping("/{idFamilia}")
    public ResponseEntity<?> atualizarFamilia(@PathVariable("idFamilia") Integer idFamilia,
                                              @RequestBody Familia familiaAtualizada) {
        Familia familiaAtual = familiaRepository.findById(idFamilia).get();
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
    public ResponseEntity<?> deletarFamilia(@PathVariable("idFamilia") Integer idFamilia) {
        familiaRepository.deleteById(idFamilia);
        return ResponseEntity.ok().body("Familia deletada");
    }

}
