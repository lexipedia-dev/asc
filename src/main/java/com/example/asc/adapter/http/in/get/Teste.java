package com.example.asc.adapter.http.in.get;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {


    @GetMapping("/teste")
    public void teste(){
        System.out.println("Imprimindo através do entpoint: ");
    }
}
