package br.com.seuprojeto.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequestDTO {
    @Future
    private LocalDateTime dataHora;

    @NotEmpty
    private List<String> tratamentosIds; // IDs dos tratamentos
}