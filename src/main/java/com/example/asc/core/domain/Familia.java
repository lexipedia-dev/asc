package com.example.asc.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String endereco;
    private String numero;
    private String bairro;
    private String sus;
    private String cpf;
    private String nomeResponsavel;
    @OneToMany(
            mappedBy = "familia",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MembroFamilia> membroFamilia = new ArrayList<>();
}
