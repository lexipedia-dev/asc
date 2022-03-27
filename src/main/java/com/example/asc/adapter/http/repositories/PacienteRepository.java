package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
