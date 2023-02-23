package org.senai.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.senai.bookstore.domain.Categoria;
import org.senai.bookstore.repositories.CategoriaRepository;
import org.senai.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById (Integer id){
        Optional<Categoria> obj = repository.findById(id); 
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
}

    public List<Categoria> findAll(){
        return repository.findAll();
    }
}