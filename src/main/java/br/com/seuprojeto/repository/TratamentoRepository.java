package br.com.seuprojeto.repository;

import br.com.seuprojeto.model.Tratamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentoRepository extends MongoRepository<Tratamento, String> {
}
