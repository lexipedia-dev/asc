package com.example.asc.adapter.http.dto.saida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TokenDtoOut {
    private String token;
    private String bearer;
}
