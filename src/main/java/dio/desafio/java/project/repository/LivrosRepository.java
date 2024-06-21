package dio.desafio.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.desafio.java.project.model.Livros;

public interface LivrosRepository extends JpaRepository<Livros,Integer> {

}
