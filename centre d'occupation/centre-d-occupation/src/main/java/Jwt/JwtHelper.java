package Jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import documents.Personne;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
@Component
@Log4j2
public class JwtHelper {
    static final String issuer = "kidsKiller";
    @Value("#{${accessTokenExpirationMinutes}* 60*1000}")
    private int accessTokenExpirationMs;
    @Value("#{${refreshTokenExpirationdays}* 24*60*60*1000}")
    private int refreshTokenExpirationMs;
    private Algorithm accessTokenAlgorithm;
    private Algorithm refreshTokenAlgorithm;
    private JWTVerifier accessTokenverifier;
    private JWTVerifier refreshTokenverifier;

    public JwtHelper(@Value("${accessTokenSecret}") String accessTokenSecret, @Value("${refreshTokenSecret}") String refreshTokenSecret) {
        accessTokenAlgorithm = Algorithm.HMAC512(accessTokenSecret);
        refreshTokenAlgorithm = Algorithm.HMAC512(refreshTokenSecret);
        accessTokenverifier = JWT.require(accessTokenAlgorithm).withIssuer(issuer).build();
        refreshTokenverifier = JWT.require(refreshTokenAlgorithm).withIssuer(issuer).build();
    }

    public String getAccessToken(Personne user) {
        return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getId())
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(new Date().getTime() + accessTokenExpirationMs)).sign(accessTokenAlgorithm);
    }
    public String getRefreshToken(Personne user, String tokenId) {
        return JWT.create()
                .withIssuer(issuer)
                .withClaim("tokenId", tokenId)
                .withSubject(user.getId())
                .withSubject(user.getRole())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(new Date().getTime() + refreshTokenExpirationMs)).sign(refreshTokenAlgorithm);
    }
    private Optional<DecodedJWT> decodeAccessToken(String token){
        try {
            return Optional.of(accessTokenverifier.verify(token));
        }catch (JWTVerificationException e) {
            log.error("invalid token ",e);
        }
        return Optional.empty();
    }
    private Optional<DecodedJWT> decodeRefreshToken(String token){
        try {
            return Optional.of(refreshTokenverifier.verify(token));
        }catch (JWTVerificationException e) {
            log.error("invalid refreshtoken ",e);
        }
        return Optional.empty();
    }
    public boolean validateAccessToken(String token){
        return  decodeAccessToken(token).isPresent();
    }
    public boolean validateRefreshToken(String token){
        return  decodeRefreshToken(token).isPresent();
    }
    public String getUserInfoFromaccessToken(String token){
        return decodeAccessToken(token).get().getSubject();
    }
    public String getUserInfoFromrefreshToken(String token){
        return decodeAccessToken(token).get().getClaim("tokenId").toString();
    }

}
