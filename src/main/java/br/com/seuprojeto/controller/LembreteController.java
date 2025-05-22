package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.service.LembreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lembretes")
@RequiredArgsConstructor
public class LembreteController {

    private final LembreteService lembreteService;

    @GetMapping
    public ResponseEntity<List<LembreteResponseDTO>> listarLembretes(
            @RequestParam(required = false) String usuarioId,
            Authentication authentication
    ) {
        if (usuarioId == null && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            usuarioId = null; // Admin vê todos
        } else if (usuarioId == null) {
            usuarioId = ((Usuario) authentication.getPrincipal()).getId(); // User vê só os seus
        }
        return ResponseEntity.ok(lembreteService.listarLembretes(usuarioId));
    }

    @PostMapping
    public ResponseEntity<LembreteResponseDTO> criarLembrete(
            @RequestBody LembreteRequestDTO request,
            Authentication authentication
    ) {
        String usuarioEmail = authentication.getName();
        return ResponseEntity.ok(lembreteService.criarLembrete(request, usuarioEmail));
    }
}