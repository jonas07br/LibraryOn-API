package dio.desafio.java.project.dto;

import java.util.List;

public record LivrosDTO(
    Integer id,
    String titulo,
    String descricao,
    List<String> genero
) {

}
