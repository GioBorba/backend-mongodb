package br.com.seuprojeto.controller;

import br.com.seuprojeto.dto.ConsultaRequestDTO;
import br.com.seuprojeto.model.Consulta;
import br.com.seuprojeto.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public Consulta criarConsulta(@RequestBody @Valid ConsultaRequestDTO dto) {
        return consultaService.criarConsulta(dto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Consulta> listarConsultas(@PathVariable String usuarioId) {
        return consultaService.listarConsultasPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Consulta atualizarConsulta(@PathVariable String id, @RequestBody @Valid ConsultaRequestDTO dto) {
        return consultaService.atualizarConsulta(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable String id) {
        consultaService.deletarConsulta(id);
    }
}
