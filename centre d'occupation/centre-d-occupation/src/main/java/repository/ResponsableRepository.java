package repository;

import documents.Responsable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponsableRepository extends MongoRepository <Responsable,String> {
}
