package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Recado;

import java.util.List;

public interface CustomRepository {


    List<Object> findByQuery(String tabela, List<String> parametros, List<String> valores);
    List<Object> findByQuery(String tabela, String parametro, String valor);
}
