package Service;

import Config.JwtService;
import Repository.UserRepository;
import Util.AuthenticationRequest;
import Util.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
public AuthenticationResponse authenticate(AuthenticationRequest request){
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
    ));
    var user = repository.findByEmaiL(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();
}
}
