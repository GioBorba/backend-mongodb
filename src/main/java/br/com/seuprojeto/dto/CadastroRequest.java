package br.com.seuprojeto.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class CadastroRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String senha;


}