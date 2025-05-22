package br.com.seuprojeto.repository;

import br.com.seuprojeto.model.Lembrete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LembreteRepository extends MongoRepository<Lembrete, String> {
    List<Lembrete> findByUsuarioId(String usuarioId);
}
