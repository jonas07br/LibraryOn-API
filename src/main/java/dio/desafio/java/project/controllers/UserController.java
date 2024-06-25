package dio.desafio.java.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Optional<User>> find(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUser(email));
    }
    
    @GetMapping("/findall")
    public ResponseEntity<List<User>> findall(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findall());
    }

    @PutMapping
    public ResponseEntity<User> updateuser(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userDTO));
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@Valid @RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.delete(userDTO));
    }

}
