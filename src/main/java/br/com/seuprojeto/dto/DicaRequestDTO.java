package br.com.seuprojeto.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DicaRequestDTO {
    @NotBlank
    private String mensagem;
}