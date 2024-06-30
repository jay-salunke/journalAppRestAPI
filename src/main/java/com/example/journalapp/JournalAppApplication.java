package com.example.journalapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JournalAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(JournalAppApplication.class, args);

    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
