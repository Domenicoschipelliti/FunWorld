package domenico.CapStoneProject.security;

import domenico.CapStoneProject.enteties.User;
import domenico.CapStoneProject.exceptions.Unauthorized;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTclass {
    @Value("${spring_JwT_key}")
    private String codiceSegreto;

    public String createToken(User user){
        return Jwts.builder().subject(String.valueOf(user.getUserId())) // Subject <-- A chi appartiene il token (id dell'utente)
                .issuedAt(new Date(System.currentTimeMillis())) // Data di emissione (IAT - Issued At)
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // Data di scadenza (Expiration Date)
                .signWith(Keys.hmacShaKeyFor(codiceSegreto.getBytes())) // Firmo il token
                .compact();
    }
    public void verifyToken(String token){
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(codiceSegreto.getBytes())).build().parse(token);
        } catch (Exception ex) {
            throw new Unauthorized("Problemi col token! Per favore effettua di nuovo il login!");
        }
    }
    public String extractIdFromToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(codiceSegreto.getBytes()))
                .build()
                .parseSignedClaims(token).getPayload().getSubject();
    }
}
