package org.senai.bookstore.Service;

import java.util.Optional;

import org.senai.bookstore.domain.Categoria;
import org.senai.bookstore.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById (Integer id){
        Optional<Categoria> obj = repository.findById(id); 
        return obj.orElse(null);
}
}