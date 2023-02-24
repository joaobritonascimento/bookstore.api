package org.senai.bookstore.domain;

import java.io.Serializable;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Livro implements Serializable{ 

    private static final long serialVersionUID=1L; //1L define que essa é a primeira versão da classe.

    @Id //Informa que o id é uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @NotEmpty(message = "Campo TITULO é obrigatório")
    @Length(min =3, max = 50, message = "O campo TITULO de deve entre 3 e 50 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo NOME DO AUTOR é obrigatório")
    @Length(min =3, max = 50, message = "O campo NOME DO AUTOR de deve entre 3 e 50 caracteres")
    private String nome_autor;

    @NotEmpty(message = "Campo TEXTO é obrigatório")
    @Length(min =10, max = 20000000, message = "O campo TEXTO de deve entre 10 e 2.000.000 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")

    private Categoria categoria;

    public Livro(){
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        super ();
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
