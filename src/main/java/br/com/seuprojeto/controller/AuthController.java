package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.CadastroRequest;
import br.com.seuprojeto.dto.LoginRequestDTO;
import br.com.seuprojeto.dto.LoginResponseDTO;
import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.service.AuthService;
import br.com.seuprojeto.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody @Valid CadastroRequest request) {
        return authService.cadastrarUsuario(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        Usuario usuario = usuarioService.autenticar(loginRequest.getEmail(), loginRequest.getSenha());

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        LoginResponseDTO responseDTO = LoginResponseDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();

        return ResponseEntity.ok(responseDTO);
    }

}
