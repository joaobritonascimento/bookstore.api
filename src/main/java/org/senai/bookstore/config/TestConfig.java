package org.senai.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.senai.bookstore.Service.DBService;

@Configuration
@Profile("test") //Noem do perfil test
public class TestConfig {
    
    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaBaseDeDados(){
        this.dbService.instanciaBaseDeDados();
    }
}
