package dio.desafio.java.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.desafio.java.project.dto.EmprestimoDTO;
import dio.desafio.java.project.model.Emprestimos;
import dio.desafio.java.project.model.Livros;
import dio.desafio.java.project.model.User;
import dio.desafio.java.project.repository.EmprestimoRepository;
import dio.desafio.java.project.repository.LivrosRepository;
import dio.desafio.java.project.repository.UserRepository;

@Service
public class EmprestimoService {
    @Autowired
    EmprestimoRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LivrosRepository livrosRepository;


    public Emprestimos create(EmprestimoDTO emprestimoDTO){
        //checar se o usuario/livro existem
        checkDTO(emprestimoDTO);
        
        Emprestimos emprestimos = new Emprestimos();
        if(repository.findByuserEmail(emprestimoDTO.userEmail()).size()>2){
            throw new RuntimeException("Usuario possui mais de 2 emprestimos");
        }
        else{
            BeanUtils.copyProperties(emprestimoDTO, emprestimos);
            emprestimos.setValidade(LocalDate.now().plusMonths(1));
            repository.save(emprestimos);
            return emprestimos;
        }

    }

    public String delete(EmprestimoDTO emprestimoDTO){
        //checar se o usuario/livro existem
        checkDTO(emprestimoDTO);

        if(repository.findById(emprestimoDTO.id()).isPresent()){
            Emprestimos emprestimo = new Emprestimos();
            BeanUtils.copyProperties(emprestimoDTO,emprestimo);
            
            repository.delete(emprestimo);

            return "Deletado";
        }
        else{
            return "Emprestimo nao encontrado";
        }
    }

    public List<Emprestimos> findall(){
        return repository.findAll();
    }
    public void checkDTO(EmprestimoDTO emprestimoDTO){
        Optional<User> userTest = userRepository.findById(emprestimoDTO.userEmail());
        Optional<Livros> livroTest = livrosRepository.findById(emprestimoDTO.livroId());

        if(userTest.isEmpty()){
            throw new RuntimeException("Usuario não encontrados.");
        }
        if(livroTest.isEmpty()){
            throw new RuntimeException("Livro não encontrado.");
        }
    }
}
