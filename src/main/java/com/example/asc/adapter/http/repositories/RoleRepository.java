package com.example.asc.adapter.http.repositories;

import com.example.asc.core.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Perfil, Integer> {
}
