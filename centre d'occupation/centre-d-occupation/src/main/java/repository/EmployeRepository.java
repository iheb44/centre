package repository;

import documents.Employe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeRepository extends MongoRepository<Employe,String> {
}
