package org.senai.bookstore.repositores;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.senai.bookstore.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
