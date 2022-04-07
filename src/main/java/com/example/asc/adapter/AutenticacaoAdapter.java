package com.example.asc.adapter;

import com.example.asc.adapter.http.dto.entrada.LoginDtoIn;
import com.example.asc.config.security.TokenServiceAsc;
import com.example.asc.core.ports.AutenticacaoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoAdapter implements AutenticacaoUseCase {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServiceAsc tokenService;

    @Override
    public String autenticar(LoginDtoIn form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.gerarDadosLogin();
        Authentication authentication = authenticationManager.authenticate(dadosLogin);
        String token = tokenService.gerarToken(authentication);
        return token;
    }
}
