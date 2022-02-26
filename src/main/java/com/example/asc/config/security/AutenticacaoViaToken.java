package com.example.asc.config.security;

import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.token.TokenService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@AllArgsConstructor
public class AutenticacaoViaToken extends OncePerRequestFilter {

    private TokenServiceAsc tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean tokenValido = tokenService.tokenValido(token);
        System.out.println(tokenValido);

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
