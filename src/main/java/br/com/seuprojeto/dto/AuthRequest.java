package br.com.seuprojeto.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class AuthRequest {
    private String email;
    private String senha;
}