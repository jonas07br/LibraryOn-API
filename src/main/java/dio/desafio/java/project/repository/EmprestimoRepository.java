package dio.desafio.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.desafio.java.project.model.Emprestimos;

public interface EmprestimoRepository extends JpaRepository<Emprestimos,Integer> {

}
