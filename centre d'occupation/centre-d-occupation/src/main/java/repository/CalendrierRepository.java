package repository;

import documents.Calendrier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalendrierRepository extends MongoRepository<Calendrier,String> {
}
