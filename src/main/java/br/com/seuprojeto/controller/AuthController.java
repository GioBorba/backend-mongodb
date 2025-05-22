// AuthController.java
package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }


    @PostMapping("/cadastro")
    public ResponseEntity<TokenResponse> cadastrar(@RequestBody CadastroRequest request) {
        return ResponseEntity.ok(authService.cadastrar(request));
    }
}