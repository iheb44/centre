package repository;

import documents.Personne;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

import java.util.Optional;

public interface PersonneRepository extends MongoRepository<Personne,String> {
    Optional <Personne> findByEmail(String email);
}
