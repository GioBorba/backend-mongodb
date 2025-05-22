package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listarConsultas(
            @RequestParam(required = false) String usuarioId,
            Authentication authentication
    ) {
        if (usuarioId == null && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            usuarioId = null; // Admin vê todas
        } else if (usuarioId == null) {
            usuarioId = ((Usuario) authentication.getPrincipal()).getId(); // User vê só as suas
        }
        return ResponseEntity.ok(consultaService.listarConsultas(usuarioId));
    }

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> criarConsulta(
            @RequestBody ConsultaRequestDTO request,
            Authentication authentication
    ) {
        String usuarioEmail = authentication.getName();
        return ResponseEntity.ok(consultaService.criarConsulta(request, usuarioEmail));
    }
}