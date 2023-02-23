package org.senai.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.senai.bookstore.domain.Livro;
import org.senai.bookstore.dtos.LivroDTO;
import org.senai.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
    
    @Autowired
    private LivroService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<Livro> findbyId(@PathVariable Integer id){
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
            }
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue="0") Integer id_cat){
        List<Livro> list = service.findAll(id_cat);
        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
