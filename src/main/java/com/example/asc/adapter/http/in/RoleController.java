package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.RoleRepository;
import com.example.asc.core.domain.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/cadastrar-role")
    public ResponseEntity<?> cadastrarRole(@RequestBody Perfil perfil){
        String nomeRoleAtual = perfil.getNome();
        perfil.setNome("ROLE_"+nomeRoleAtual);
        roleRepository.save(perfil);
        return ResponseEntity.ok().body("Role cadastrada");
    }
}
