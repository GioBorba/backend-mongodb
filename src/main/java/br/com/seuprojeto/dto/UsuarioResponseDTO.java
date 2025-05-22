package br.com.seuprojeto.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UsuarioResponseDTO {
    private String id;
    private String nome;
    private String email;

}