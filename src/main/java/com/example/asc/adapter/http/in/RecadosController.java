package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.RecadoRepository;
import com.example.asc.core.domain.Recado;
import com.example.asc.core.domain.Usuario;
import com.example.asc.utils.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recado")
public class RecadosController {

    @Autowired
    private RecadoRepository recadoRepository;
    @Autowired
    private QueryBuilder queryBuilder;

    @PostMapping
    public ResponseEntity<?> cadastrarRecado(@RequestBody Recado recado,
                                             @AuthenticationPrincipal Usuario usuario){
        recado.setUsuario(usuario);
        recadoRepository.save(recado);
        return ResponseEntity.ok("Recado cadastrado");
    }

    @GetMapping
    public ResponseEntity<?> buscarRecados(@Param("nome")String nome,
                                           @Param("sus")String sus,
                                           @Param("dataNascimento")String dataNascimento,
                                           @Param("endereco")String endereco,
                                           @Param("numero")String numero,
                                           @Param("bairro")String bairro,
                                           @Param("recado")String recado){
        if(nome == null &&
           sus == null &&
           dataNascimento == null &&
           endereco == null &&
           numero == null &&
           bairro == null &&
           recado == null){

            return ResponseEntity.ok().body(recadoRepository.findAll());
        }

        List<String> parametros = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        if(nome != null){
            parametros.add("nome");
            valores.add(nome);
        }
        if(sus != null){
            parametros.add("sus");
            valores.add(sus);
        }
        if(dataNascimento != null){
            parametros.add("dataNascimento");
            valores.add(dataNascimento);
        }
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
        if(recado != null){
            parametros.add("recado");
            valores.add(recado);
        }

        List<Object> response;
        if(parametros.size() == 1 && valores.size() == 1){
            response = recadoRepository.findByQuery("Recado", parametros.get(0), valores.get(0));
        }else {
            response = recadoRepository.findByQuery("Recado", parametros, valores);
        }
        return ResponseEntity.ok().body(response);

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
