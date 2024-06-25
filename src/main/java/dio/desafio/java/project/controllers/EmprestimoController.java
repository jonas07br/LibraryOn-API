package dio.desafio.java.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.desafio.java.project.dto.EmprestimoDTO;
import dio.desafio.java.project.model.Emprestimos;
import dio.desafio.java.project.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @Autowired
    public EmprestimoService service;

    @GetMapping
    public ResponseEntity<List<Emprestimos>> findall(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findall());
    }

    @PostMapping
    public ResponseEntity<Emprestimos> create(@RequestBody EmprestimoDTO emprestimoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(emprestimoDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody EmprestimoDTO emprestimoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(emprestimoDTO));
    }
}
