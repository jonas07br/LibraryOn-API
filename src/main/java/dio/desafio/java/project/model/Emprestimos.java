package dio.desafio.java.project.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="emprestimos")
public class Emprestimos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_email")
    private String user_email;

    @Column(name="livro_id")
    private Integer livro_id;

    @Column(name="validade")
    private LocalDate validade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Integer getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Integer livro_id) {
        this.livro_id = livro_id;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    
}
