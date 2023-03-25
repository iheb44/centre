package service;

import documents.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.PersonneRepository;
@Service
public class PersonService {
    @Autowired
    private PersonneRepository perRepo;
    public Personne findById(String id) {
        return perRepo.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("user id not found"));
    }
}
