package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.LembreteRequestDTO;
import br.com.seuprojeto.model.Lembrete;
import br.com.seuprojeto.service.LembreteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
@RequiredArgsConstructor
public class LembreteController {

    private final LembreteService lembreteService;

    @PostMapping
    public Lembrete criar(@RequestBody @Valid LembreteRequestDTO dto) {
        return lembreteService.criarLembrete(dto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Lembrete> listar(@PathVariable String usuarioId) {
        return lembreteService.listarPorUsuario(usuarioId);
    }


    @PutMapping("/{id}")
    public Lembrete atualizar(@PathVariable String id, @RequestBody @Valid LembreteRequestDTO dto) {
        return lembreteService.atualizarLembrete(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        lembreteService.deletarLembrete(id);
    }
}
