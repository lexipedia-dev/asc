package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.repositories.RoleRepository;
import com.example.asc.core.domain.Perfil;
import com.example.asc.core.domain.Usuario;
import com.example.asc.adapter.http.repositories.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @NotNull Usuario usuario){
        usuario.encryptPassword();
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado");
    }

    @PostMapping("/cadastrar-admin")
    public ResponseEntity<?> cadastrarUsuarioAdmin(@RequestBody @NotNull Usuario usuario){
        usuario.encryptPassword();
        Perfil perfil = new Perfil();
        perfil.setNome("ROLE_ADMIN");
        roleRepository.save(perfil);
        List<Perfil> perfis = new ArrayList<>();
        perfis.add(perfil);
        usuario.setPerfis(perfis);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado");
    }

    @PutMapping("/usuario/{idUsuario}/tornar-admin")
    public ResponseEntity<?> tornarUsuarioComum(@PathVariable("idUsuario") Integer idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        Perfil perfil = new Perfil();
        perfil.setNome("ROLE_ADMIN");
        roleRepository.save(perfil);
        List<Perfil> perfis = new ArrayList<>();
        perfis.add(perfil);
        usuario.setPerfis(perfis);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário alterado para administrador");
    }

    @GetMapping
    public ResponseEntity<?> buscarusuarios(){
        return ResponseEntity.ok().body(usuarioRepository.findAll());
    }

}
