package com.example.asc.core.repositories;

import com.example.asc.core.domain.Patologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatologiaRepository extends JpaRepository<Patologia, Integer> {
}
