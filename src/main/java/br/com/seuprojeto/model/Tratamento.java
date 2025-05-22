package br.com.seuprojeto.model;

import lombok.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;

@Document(collection = "tratamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tratamento {
    @Id
    private String id;

    @NotBlank(message = "Nome do tratamento é obrigatório")
    private String nome;
}