package com.example.asc.adapter.http.in;

import com.example.asc.adapter.http.dto.entrada.LoginDtoIn;
import com.example.asc.adapter.http.dto.saida.TokenDtoOut;
import com.example.asc.config.security.TokenServiceAsc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServiceAsc tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDtoIn form){
        UsernamePasswordAuthenticationToken dadosLogin = form.gerarDadosLogin();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            System.out.println(token);
            return ResponseEntity.ok(new TokenDtoOut(token, "Bearer"));
        } catch (AuthenticationException ex){
            return ResponseEntity.badRequest().build();
        }


    }
}
