package com.example.asc.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class MembroFamilia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String dataNascimento;
    private String sus;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Familia familia;
}
