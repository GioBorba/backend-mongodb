package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.service.TratamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamentos")
@RequiredArgsConstructor
public class TratamentoController {

    private final TratamentoService tratamentoService;

    @GetMapping
    public ResponseEntity<List<TratamentoResponseDTO>> listarTratamentos() {
        return ResponseEntity.ok(tratamentoService.listarTratamentos());
    }

    @PostMapping
    public ResponseEntity<TratamentoResponseDTO> criarTratamento(@RequestBody TratamentoRequestDTO request) {
        return ResponseEntity.ok(tratamentoService.criarTratamento(request));
    }
}