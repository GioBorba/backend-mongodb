package br.com.seuprojeto.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LembreteRequestDTO {
    @NotBlank
    private String mensagem;

    @FutureOrPresent
    private LocalDateTime dataHora;

    private String usuarioId;
}
