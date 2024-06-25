package dio.desafio.java.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import dio.desafio.java.project.dto.LivrosDTO;
import dio.desafio.java.project.model.Livros;
import dio.desafio.java.project.service.LivrosService;
import feign.Response;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    @Autowired
    LivrosService livrosService;

    @PostMapping
    public ResponseEntity<Livros> create(@RequestBody LivrosDTO livrosDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(livrosService.create(livrosDTO));

    }
    @GetMapping
    public ResponseEntity<List<Livros>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosService.findAll());
    }

    @PutMapping
    public ResponseEntity<Livros> updateLivro(@RequestBody LivrosDTO livrosDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livrosService.updLivro(livrosDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> remove(@RequestBody LivrosDTO livrosDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livrosService.removeLivro(livrosDTO));
    }
}
