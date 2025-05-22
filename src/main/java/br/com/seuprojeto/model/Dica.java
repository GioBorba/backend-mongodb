package br.com.seuprojeto.model;

import lombok.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;

@Document(collection = "dicas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Dica {
    @Id
    private String id;

    @NotBlank(message = "Mensagem é obrigatória")
    private String mensagem;
}