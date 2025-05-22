package br.com.seuprojeto.service;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.model.*;
import br.com.seuprojeto.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DicaService {

    private final DicaRepository dicaRepository;

    public List<DicaResponseDTO> listarDicas() {
        return dicaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('ADMIN')")
    public DicaResponseDTO criarDica(DicaRequestDTO request) {
        Dica dica = new Dica();
        dica.setMensagem(request.getMensagem());
        Dica savedDica = dicaRepository.save(dica);
        return convertToDTO(savedDica);
    }

    private DicaResponseDTO convertToDTO(Dica dica) {
        return DicaResponseDTO.builder()
                .id(dica.getId())
                .mensagem(dica.getMensagem())
                .build();
    }
}