package security;

import Jwt.JwtHelper;
import org.springframework.stereotype.Service;
import service.PersonService;
import documents.Personne;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import java.io.IOException;
import java.util.Optional;
@Service
public class accessTokenFilter extends OncePerRequestFilter {
   @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private PersonService personService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
try {
    Optional<String> accessToken =parseAccessToken(request);
    if (accessToken.isPresent() && jwtHelper.validateAccessToken(accessToken.get())) {
String Id = jwtHelper.getUserInfoFromaccessToken(accessToken.get());
Personne user =personService.findById(Id);
        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
        upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(upat);
    }
}catch () {
    return
}
    }
    private  Optional<String> parseAccessToken(HttpServletRequest request){
        String  authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader)&&authHeader.startsWith("Bearer ")){
            return Optional.of(authHeader.replace("Bearer ",""));

        }
        return Optional.empty();

    }
}
