package br.com.seuprojeto.service;

import br.com.seuprojeto.dto.ConsultaRequestDTO;
import br.com.seuprojeto.model.Consulta;
import br.com.seuprojeto.model.Tratamento;
import br.com.seuprojeto.model.Usuario;
import br.com.seuprojeto.repository.ConsultaRepository;
import br.com.seuprojeto.repository.TratamentoRepository;
import br.com.seuprojeto.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TratamentoRepository tratamentoRepository;

    public Consulta criarConsulta(ConsultaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Tratamento> tratamentos = tratamentoRepository.findAllById(dto.getTratamentosIds());

        Consulta consulta = new Consulta();
        consulta.setNome(dto.getNome());
        consulta.setDataHora(dto.getDataHora());
        consulta.setUsuario(usuario);
        consulta.setTratamentos(tratamentos);

        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultasPorUsuario(String usuarioId) {
        return consultaRepository.findByUsuarioId(usuarioId);
    }

    public Optional<Consulta> buscarPorId(String id) {
        return consultaRepository.findById(id);
    }

    public Consulta atualizarConsulta(String id, ConsultaRequestDTO dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        List<Tratamento> tratamentos = tratamentoRepository.findAllById(dto.getTratamentosIds());
        consulta.setNome(dto.getNome());
        consulta.setDataHora(dto.getDataHora());
        consulta.setTratamentos(tratamentos);

        return consultaRepository.save(consulta);
    }

    public void deletarConsulta(String id) {
        consultaRepository.deleteById(id);
    }
}
