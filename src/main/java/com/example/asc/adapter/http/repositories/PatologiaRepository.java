package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Patologia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatologiaRepository extends JpaRepository<Patologia, Integer> {
}
