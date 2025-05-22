package br.com.seuprojeto.service;

import br.com.seuprojeto.dto.LembreteRequestDTO;
import br.com.seuprojeto.dto.LembreteResponseDTO;
import br.com.seuprojeto.model.Lembrete;
import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.repository.LembreteRepository;
import br.com.seuprojeto.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LembreteService {

    private final LembreteRepository lembreteRepository;
    private final UsuarioRepository usuarioRepository;

    public Lembrete criarLembrete(LembreteRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Lembrete lembrete = new Lembrete();
        lembrete.setMensagem(dto.getMensagem());
        lembrete.setDataHora(dto.getDataHora());
        lembrete.setUsuario(usuario);

        return lembreteRepository.save(lembrete);
    }


    public List<LembreteResponseDTO> listarPorUsuario(String usuarioId) {
        return lembreteRepository.findByUsuarioId(usuarioId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private LembreteResponseDTO convertToDto(Lembrete lembrete) {
        return LembreteResponseDTO.builder()
                .id(lembrete.getId())
                .mensagem(lembrete.getMensagem())
                .dataHora(lembrete.getDataHora())
                .build();
    }


    public Lembrete atualizarLembrete(String id, LembreteRequestDTO dto) {
        Lembrete lembrete = lembreteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lembrete não encontrado"));

        lembrete.setMensagem(dto.getMensagem());
        lembrete.setDataHora(dto.getDataHora());

        return lembreteRepository.save(lembrete);
    }



    public void deletarLembrete(String id) {
        lembreteRepository.deleteById(id);
    }
}
