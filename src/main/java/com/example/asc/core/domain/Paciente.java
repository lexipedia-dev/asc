package com.example.asc.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String sus;
    private String cpf;
    private String telefone;
    private String endereco;
    private String numeroCasa;
    private String bairro;
    private String temPatologia;
    private String necessitaVisitaMedica;
    private String tomaRemedioControlado;
    private String temDependente;
    private String fuma;
    private String bebe;
    private String idoso;
    private String cancer;
    private String filhos;
    private String rg;
}
