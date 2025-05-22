package br.com.seuprojeto.repository;

import br.com.seuprojeto.model.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends MongoRepository<Consulta, String> {
    List<Consulta> findByUsuarioId(String usuarioId);
}
