package dio.desafio.java.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.desafio.java.project.dto.UserDTO;
import dio.desafio.java.project.model.User;
import dio.desafio.java.project.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
//CRUD OK--------------------
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{email}")
    public Optional<User> find(@PathVariable String email){
        return userService.findUser(email);
    }
    @GetMapping("/findall")
    public List<User> findall(){
        return userService.findall();
    }
    @PutMapping
    public String updateuser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return "Usuario "+userDTO.name()+" atualizado";
    }

    @PostMapping
    public String create(@Valid @RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return "User salvo";
    }

    @DeleteMapping
    public String delete(@Valid @RequestBody UserDTO userDTO){
        userService.delete(userDTO);
        return "Usuario removido";
    }

}
