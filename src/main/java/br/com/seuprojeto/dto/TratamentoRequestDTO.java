package br.com.seuprojeto.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TratamentoRequestDTO {
    @NotBlank
    private String nome;
}