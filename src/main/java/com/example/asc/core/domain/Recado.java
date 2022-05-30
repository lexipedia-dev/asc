package com.example.asc.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Recado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    private String nome;
    private String sus;
    private String dataNascimento;
    private String endereco;
    private String numero;
    private String bairro;
    private String recado;

    public Specification<Recado> toSpec(){

        return (root, query, builder) ->{
            List<Predicate> predicados = new ArrayList<Predicate>();
            if(StringUtils.hasText(nome)){
                Path<String> campoNome = root.<String>get("nome");
                Predicate predicadoNome = builder.like(campoNome, "%"+nome+"%");
                predicados.add(predicadoNome);
            }
            return builder.and(predicados.toArray(new Predicate[0]));
        };
    }

}
