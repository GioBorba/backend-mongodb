package br.com.seuprojeto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "consultas")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id
    private String id;

    @Future(message = "A data da consulta deve ser futura")
    private LocalDateTime dataHora;

    @DBRef
    private Usuario usuario;

    @NotEmpty(message = "Selecione pelo menos um tratamento")
    @DBRef
    private List<Tratamento> tratamentos;
}