package com.example.asc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AscApplication {

    public static void main(String[] args) {
        SpringApplication.run(AscApplication.class, args);
    }

/*
    @Component
    public static class Runner implements ApplicationRunner{

        @Override
        public void run(ApplicationArguments args) throws Exception {

        }
    }
*/

}
