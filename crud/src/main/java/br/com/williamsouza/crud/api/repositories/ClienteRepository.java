package br.com.williamsouza.crud.api.repositories;

import br.com.williamsouza.crud.api.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente,String> {

    Cliente findOne(String id);
}
