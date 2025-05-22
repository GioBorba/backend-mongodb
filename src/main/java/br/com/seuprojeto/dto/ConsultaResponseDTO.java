package br.com.seuprojeto.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ConsultaResponseDTO {
    private String id;
    private LocalDateTime dataHora;
    private String usuarioId;
    private String usuarioNome;
    private List<String> tratamentosNomes; // Nomes para exibição
}