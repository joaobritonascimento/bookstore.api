package org.senai.bookstore.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.senai.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

    //Criar a Query no formato JPQL - Metodo que ira listar todos os livros daquela categoria
    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")    
    List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat); //Metodo findAllByCategoria
    
}
