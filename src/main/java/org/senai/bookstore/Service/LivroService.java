package org.senai.bookstore.service;

import java.util.Optional;

import org.senai.bookstore.domain.Livro;
import org.senai.bookstore.repositories.LivroRepository;
import org.senai.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;
    
    public Livro findById(Integer id){
         Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! id:" + id + ", Tipo: " + Livro.class.getName()));

    }
    
}
