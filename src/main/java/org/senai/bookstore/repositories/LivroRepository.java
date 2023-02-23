package org.senai.bookstore.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.senai.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
    
}
