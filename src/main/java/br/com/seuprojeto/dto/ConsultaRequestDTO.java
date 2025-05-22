package br.com.seuprojeto.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private LocalDateTime dataHora;

    private List<String> tratamentosIds; // IDs dos tratamentos

    private String usuarioId;
}
