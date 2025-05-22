package br.com.seuprojeto.model;

import lombok.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Document(collection = "lembretes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Lembrete {
    @Id
    private String id;

    @NotBlank(message = "Mensagem é obrigatória")
    private String mensagem;

    @FutureOrPresent(message = "A data do lembrete deve ser futura ou atual")
    private LocalDateTime dataHora;

    @DBRef
    private Usuario usuario; // Referência ao usuário
}