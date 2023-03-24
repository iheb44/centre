package repository;

import documents.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupeRepository extends MongoRepository<Groupe,String> {
}
