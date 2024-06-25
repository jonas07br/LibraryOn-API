package dio.desafio.java.project.repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import dio.desafio.java.project.model.Emprestimos;


public interface EmprestimoRepository extends JpaRepository<Emprestimos,Integer> {
    public List<Emprestimos> findByuserEmail(String userEmail);

    
}
