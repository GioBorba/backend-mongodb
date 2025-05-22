package br.com.seuprojeto.repository;

import br.com.seuprojeto.model.Dica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DicaRepository extends MongoRepository<Dica, String> {
}
