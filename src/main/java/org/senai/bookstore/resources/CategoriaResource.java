package org.senai.bookstore.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.senai.bookstore.domain.Categoria;
import org.senai.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value ="/categorias") // exemplo: localhost:8080/categoria/1 <-id
public class CategoriaResource {

    @Autowired
    private CategoriaService service; 

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById (@PathVariable Integer id){ //Método findById
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
