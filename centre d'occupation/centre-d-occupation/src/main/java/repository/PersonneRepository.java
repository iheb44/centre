package repository;

import documents.Personne;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonneRepository extends MongoRepository<Personne,String> {

}
