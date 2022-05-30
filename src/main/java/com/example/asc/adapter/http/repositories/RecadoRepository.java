package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Recado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecadoRepository extends JpaRepository<Recado, Integer>, JpaSpecificationExecutor<Recado>, CustomRepository {

}
