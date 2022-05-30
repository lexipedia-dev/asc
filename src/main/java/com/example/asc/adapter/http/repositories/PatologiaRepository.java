package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Patologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatologiaRepository extends JpaRepository<Patologia, Integer>, CustomRepository {

    List<Patologia> findByNomeLikeIgnoreCase(String nome);
}
