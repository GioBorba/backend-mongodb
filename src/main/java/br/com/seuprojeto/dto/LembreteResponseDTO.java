package br.com.seuprojeto.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LembreteResponseDTO {
    private String id;
    private String mensagem;
    private LocalDateTime dataHora;
    private String usuarioId;
    private String usuarioNome;
}