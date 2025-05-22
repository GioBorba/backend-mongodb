package br.com.seuprojeto.controller;

import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @GetMapping("/buscar")
    public Usuario buscarPorEmail(@RequestParam String email) {
        return usuarioService.buscarPorEmail(email);
    }
}
