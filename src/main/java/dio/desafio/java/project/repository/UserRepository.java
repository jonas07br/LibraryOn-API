package dio.desafio.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.desafio.java.project.model.User;

public interface UserRepository extends JpaRepository<User,String> {

}
