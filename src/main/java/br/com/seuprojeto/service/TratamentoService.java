package br.com.seuprojeto.service;

import br.com.seuprojeto.dto.*;
import br.com.seuprojeto.model.*;
import br.com.seuprojeto.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TratamentoService {

    private final TratamentoRepository tratamentoRepository;

    public List<TratamentoResponseDTO> listarTratamentos() {
        return tratamentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TratamentoResponseDTO criarTratamento(TratamentoRequestDTO request) {
        Tratamento tratamento = new Tratamento();
        tratamento.setNome(request.getNome());
        Tratamento savedTratamento = tratamentoRepository.save(tratamento);
        return convertToDTO(savedTratamento);
    }

    private TratamentoResponseDTO convertToDTO(Tratamento tratamento) {
        return TratamentoResponseDTO.builder()
                .id(tratamento.getId())
                .nome(tratamento.getNome())
                .build();
    }
}