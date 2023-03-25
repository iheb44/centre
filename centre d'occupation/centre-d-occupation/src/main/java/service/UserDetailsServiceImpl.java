package service;

import documents.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.PersonneRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Personne> personneOptional = personneRepository.findByEmail(email);

        if (personneOptional.isEmpty()) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }

        Personne personne = personneOptional.get();

        return new org.springframework.security.core.userdetails.User(
                personne.getEmail(),
                personne.getPassword(),
                new ArrayList<>());
    }
}