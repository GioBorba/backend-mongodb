package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.CadastroRequest;
import br.com.seuprojeto.dto.LoginRequestDTO;
import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody @Valid CadastroRequest request) {
        return authService.cadastrarUsuario(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequestDTO request) {
        return authService.login(request);
    }
}
