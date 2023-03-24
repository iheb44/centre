package repository;

import documents.Planning;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanningRepository extends MongoRepository<Planning,String> {
}
