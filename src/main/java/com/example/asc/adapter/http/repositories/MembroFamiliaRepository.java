package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Familia;
import com.example.asc.core.domain.MembroFamilia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroFamiliaRepository extends JpaRepository<MembroFamilia, Integer> {
}
