package br.com.seuprojeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor

public class TokenResponse {
    private String token;
    private String mensagem;
}