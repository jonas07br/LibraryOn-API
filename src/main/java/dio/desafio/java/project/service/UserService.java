package dio.desafio.java.project.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import dio.desafio.java.project.dto.UserDTO;
import dio.desafio.java.project.model.User;
import dio.desafio.java.project.repository.UserRepository;
import jakarta.validation.Valid;

@Component
public class UserService {
    @Autowired
    UserRepository repository;

    public void saveUser(UserDTO userDTO){
        if(repository.findById(userDTO.email()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email invalido");
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        repository.save(user);
    }

    public Optional<User> findUser(String email){
        return repository.findById(email);
    }

    public List<User> findall(){
        return repository.findAll();
    }

    public void updateUser(UserDTO userDTO){
        if(repository.findById(userDTO.email()).isPresent()){
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            repository.save(user);
            
        }
        else{
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email invalido");
        }
        
    }

    public void delete(UserDTO userDTO) {
        if(repository.findById(userDTO.email()).isPresent()){
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            repository.delete(user);
            
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario inexistente");
        }
    }

}
