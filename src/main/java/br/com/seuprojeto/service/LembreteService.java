package br.com.seuprojeto.service;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.model.*;
import br.com.seuprojeto.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LembreteService {

    private final LembreteRepository lembreteRepository;
    private final UsuarioRepository usuarioRepository;

    @PreAuthorize("hasRole('ADMIN') or #usuarioId == authentication.principal.id")
    public List<LembreteResponseDTO> listarLembretes(String usuarioId) {
        if (usuarioId != null) {
            return lembreteRepository.findByUsuarioId(usuarioId).stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }
        return lembreteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public LembreteResponseDTO criarLembrete(LembreteRequestDTO request, String usuarioEmail) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioEmail)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Lembrete lembrete = new Lembrete();
        lembrete.setMensagem(request.getMensagem());
        lembrete.setDataHora(request.getDataHora());
        lembrete.setUsuario(usuario);

        Lembrete savedLembrete = lembreteRepository.save(lembrete);
        return convertToDTO(savedLembrete);
    }

    private LembreteResponseDTO convertToDTO(Lembrete lembrete) {
        return LembreteResponseDTO.builder()
                .id(lembrete.getId())
                .mensagem(lembrete.getMensagem())
                .dataHora(lembrete.getDataHora())
                .usuarioId(lembrete.getUsuario().getId())
                .usuarioNome(lembrete.getUsuario().getNome())
                .build();
    }
}