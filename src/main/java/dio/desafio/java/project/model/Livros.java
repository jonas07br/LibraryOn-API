package dio.desafio.java.project.model;

import java.util.List;

import dio.desafio.java.project.dto.LivrosDTO;
import jakarta.persistence.*;


@Entity
@Table(name="tab_livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="titulo")
    String titulo;

    @Column(name="descricao")
    String descricao;

    @Column(name="genero")
    List<String> genero;

    public Livros(LivrosDTO livrosDTO) {
        this.id = livrosDTO.id();
        this.titulo = livrosDTO.titulo();
        this.descricao = livrosDTO.descricao();
        this.genero = livrosDTO.genero();
    }

    public Livros() {
        //TODO Auto-generated constructor stub
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }
}
