package org.senai.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import org.senai.bookstore.domain.Categoria;
import org.senai.bookstore.domain.Livro;
import org.senai.bookstore.repositores.CategoriaRepository;
import org.senai.bookstore.repositores.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired //Camadas de acesso a dados
	private CategoriaRepository categoriaRepository;
    @Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args){
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override	
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));

		this.categoriaRepository.saveAll(Arrays.asList(cat1)); //Salva tudo de uma vez só
		this.livroRepository.saveAll(Arrays.asList(l1));
	}
	
}


