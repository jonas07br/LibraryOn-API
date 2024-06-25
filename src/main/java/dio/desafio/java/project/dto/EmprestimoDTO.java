package dio.desafio.java.project.dto;

import java.time.LocalDate;

public record EmprestimoDTO(
    Integer id,
    String userEmail,
    Integer livroId,
    LocalDate validade
) {

}
