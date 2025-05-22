package br.com.seuprojeto.controller;

import br.com.seuprojeto.model.Tratamento;
import br.com.seuprojeto.service.TratamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tratamentos")
@RequiredArgsConstructor
public class TratamentoController {

    private final TratamentoService tratamentoService;

    @PostMapping
    public Tratamento criar(@RequestBody @Valid Tratamento tratamento) {
        return tratamentoService.criar(tratamento);
    }

    @GetMapping
    public List<Tratamento> listarTodos() {
        return tratamentoService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        tratamentoService.deletar(id);
    }
}
