package org.senai.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import org.senai.bookstore.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
