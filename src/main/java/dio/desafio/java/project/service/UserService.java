package dio.desafio.java.project.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dio.desafio.java.project.dto.UserDTO;
import dio.desafio.java.project.model.User;
import dio.desafio.java.project.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import nonapi.io.github.classgraph.utils.Assert;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public User saveUser(UserDTO userDTO){
        if(repository.findById(userDTO.email()).isPresent()){
            throw new RuntimeException("Email não disponivel");
        }
        if(userDTO.name()==null || userDTO.password()==null){
            throw new IllegalArgumentException("Nome ou senha estão nulos");
        }
        
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        repository.save(user);
        return user;
    }

    public Optional<User> findUser(String email){
        return repository.findById(email);
    }

    public List<User> findall(){
        return repository.findAll();
    }

    public User updateUser(UserDTO userDTO){
        if(repository.findById(userDTO.email()).isPresent()){
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            String pass = user.getPassword();
            user.setPassword(encoder.encode(pass));
            repository.save(user);
            return user;
        }
        else{
            throw new RuntimeException("Usuario não encontrado");
        }
        
    }

    public String delete(UserDTO userDTO) {
        if(repository.findById(userDTO.email()).isPresent()){
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            repository.delete(user);
            return "Deletado";
        }
        else{
            throw new RuntimeException("Usuario não encontrado");
        }
    }

}
