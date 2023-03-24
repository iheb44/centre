package repository;

import documents.Enfants;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnfantsRepository extends MongoRepository<Enfants,String> {
}
