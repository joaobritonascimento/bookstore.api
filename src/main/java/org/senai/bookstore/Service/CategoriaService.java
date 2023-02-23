package org.senai.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.senai.bookstore.domain.Categoria;
import org.senai.bookstore.dtos.CategoriaDTO;
import org.senai.bookstore.repositories.CategoriaRepository;
import org.senai.bookstore.service.exceptions.DataIntegrityViolationException;
import org.senai.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import org.senai.bookstore.domain.Categoria;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    //Metodo findById
    public Categoria findById (Integer id){ 
        Optional<Categoria> obj = repository.findById(id); 
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
}
    //Metodo findAll
    public List<Categoria> findAll(){ 
        return repository.findAll();
    }
    
    //Metodo create
    public Categoria create(Categoria obj){ 
        obj.setId(null);
        return repository.save(obj);
    }

    //Metodo update
    public Categoria update(Integer id, CategoriaDTO objDto) { 
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    // metodo delete
    public void delete(Integer id) { 
        findById(id);
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui objetos associados!");
           
        }
    }
}