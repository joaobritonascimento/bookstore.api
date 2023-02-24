package org.senai.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import org.senai.bookstore.domain.Categoria;
import org.senai.bookstore.domain.Livro;
import org.senai.bookstore.repositories.CategoriaRepository;
import org.senai.bookstore.repositories.LivroRepository;

@Service
public class DBService {

    @Autowired //Camadas de acesso a dados
	private CategoriaRepository categoriaRepository;
    @Autowired
	private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){

        Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção cientifica", "Livros de Ficção cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The war of the world", "H. G. Wells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimv", "Lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); //Salva tudo de uma vez só
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
}
}
