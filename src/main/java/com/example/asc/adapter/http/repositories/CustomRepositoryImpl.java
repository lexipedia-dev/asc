package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Recado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomRepositoryImpl implements CustomRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Object> findByQuery(String tabela, List<String> parametros, List<String> valores) {
        String query = "SELECT t FROM "+ tabela+" t WHERE ";
        for(int i=0;i<parametros.size();i++){
            query += parametros.get(i) + " LIKE " + "'%" + valores.get(i) + "%'";
            if(i != parametros.size()-1){
                query += " AND ";
            }
        }
        List<Object> recados = em.createQuery(query).getResultList();
        return recados ;
    }

    @Override
    public List<Object> findByQuery(String tabela, String parametro, String valor) {
        List<Object> recados = em.createQuery("SELECT t FROM "+ tabela+" t WHERE t." + parametro + " LIKE '%" + valor + "%'").getResultList();
        return recados;
    }
}
