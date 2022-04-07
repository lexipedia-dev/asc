package com.example.asc.core.ports;

import com.example.asc.adapter.http.dto.entrada.LoginDtoIn;

public interface AutenticacaoUseCase {
    String autenticar(LoginDtoIn form);
}
