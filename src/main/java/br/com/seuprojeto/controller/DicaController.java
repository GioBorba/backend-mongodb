package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.service.DicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dicas")
@RequiredArgsConstructor
public class DicaController {

    private final DicaService dicaService;

    @GetMapping
    public ResponseEntity<List<DicaResponseDTO>> listarDicas() {
        return ResponseEntity.ok(dicaService.listarDicas());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DicaResponseDTO> criarDica(@RequestBody DicaRequestDTO request) {
        return ResponseEntity.ok(dicaService.criarDica(request));
    }
}