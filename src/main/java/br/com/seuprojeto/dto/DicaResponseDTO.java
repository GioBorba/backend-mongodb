package br.com.seuprojeto.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DicaResponseDTO {
    private String id;
    private String mensagem;
}