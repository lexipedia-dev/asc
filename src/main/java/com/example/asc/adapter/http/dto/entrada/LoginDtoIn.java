package com.example.asc.adapter.http.dto.entrada;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginDtoIn {

    private String email;
    private String senha;

    public UsernamePasswordAuthenticationToken gerarDadosLogin() {
        return new UsernamePasswordAuthenticationToken(this.email, this.senha);
    }
}
