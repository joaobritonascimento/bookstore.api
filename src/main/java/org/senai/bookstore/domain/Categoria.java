package org.senai.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity // Pode-se passar um nome para a tabela (name = ""), se ficar sem nada a tabela se chamara o nome da classe

public class Categoria implements Serializable{

    private static final long serialVersionUID=1L; //1L define que essa é a primeira versão da classe.

    @Id //Informa que o id é uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME é obrigatório")
    @Length(min =3, max = 100, message = "O campo NOME de deve entre 3 e 100 caracteres")
    private String nome;
    
    @NotEmpty(message = "Campo DESCRIÇÃO é obrigatório")
    @Length(min =3, max = 200, message = "O campo DESCRIÇÃO de deve entre 3 e 200 caracteres")
    private String descricao;

    @OneToMany(mappedBy ="categoria")

    private List<Livro> livros = new ArrayList<>();

    public Categoria(){
        super();
    }

    public Categoria(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
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
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
