package br.com.seuprojeto.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TratamentoResponseDTO {
    private String id;
    private String nome;
}