package org.senai.bookstore.config;

import org.senai.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("dev") //Nome do perfil dev
public class DevConfig {
    
    @Autowired
    private DBService dbService;

    //o value pega o caminho/valor que esta entre chaves
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciaBaseDeDados(){
        if(strategy.equals("create")){
            this.dbService.instanciaBaseDeDados();
        }
        return false;
        
    }
    }

