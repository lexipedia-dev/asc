package com.example.asc.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //CONFIGURAÇÕES DE AUTENTICAÇÃO(LOGIN)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    //CONFIGURAÇÕES DE AUTORIZAÇÃO(URLS, PERFIS DE ACESSO À URLS, ETC.)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/usuario/cadastrar").permitAll()
                .antMatchers(HttpMethod.GET, "/teste-get").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().csrf().disable();
    }

    //CONFIGURAÇÕES DE RECURSOS ESTÁTICOS(ARQUIVOS HTML, CSS, JAVASCRIPT, IMAGENS)
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
