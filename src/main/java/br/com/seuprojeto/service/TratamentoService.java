package br.com.seuprojeto.service;

import br.com.seuprojeto.model.Tratamento;
import br.com.seuprojeto.repository.TratamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TratamentoService {

    private final TratamentoRepository tratamentoRepository;

    public Tratamento criar(Tratamento tratamento) {
        return tratamentoRepository.save(tratamento);
    }

    public List<Tratamento> listarTodos() {
        return tratamentoRepository.findAll();
    }

    public void deletar(String id) {
        tratamentoRepository.deleteById(id);
    }
}
