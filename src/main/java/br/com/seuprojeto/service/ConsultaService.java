package br.com.seuprojeto.service;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.model.*;
import br.com.seuprojeto.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TratamentoRepository tratamentoRepository;

    @PreAuthorize("hasRole('ADMIN') or #usuarioId == authentication.principal.id")
    public List<ConsultaResponseDTO> listarConsultas(String usuarioId) {
        if (usuarioId != null) {
            return consultaRepository.findByUsuarioId(usuarioId).stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }
        return consultaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConsultaResponseDTO criarConsulta(ConsultaRequestDTO request, String usuarioEmail) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioEmail)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Tratamento> tratamentos = tratamentoRepository.findAllById(request.getTratamentosIds());
        if (tratamentos.isEmpty()) {
            throw new RuntimeException("Selecione pelo menos um tratamento");
        }

        Consulta consulta = new Consulta();
        consulta.setDataHora(request.getDataHora());
        consulta.setUsuario(usuario);
        consulta.setTratamentos(tratamentos);

        Consulta savedConsulta = consultaRepository.save(consulta);
        return convertToDTO(savedConsulta);
    }

    private ConsultaResponseDTO convertToDTO(Consulta consulta) {
        return ConsultaResponseDTO.builder()
                .id(consulta.getId())
                .dataHora(consulta.getDataHora())
                .usuarioId(consulta.getUsuario().getId())
                .usuarioNome(consulta.getUsuario().getNome())
                .tratamentosNomes(consulta.getTratamentos().stream()
                        .map(Tratamento::getNome)
                        .collect(Collectors.toList()))
                .build();
    }
}