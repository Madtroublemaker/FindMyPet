package kz.kbtu.sf.findmypet.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import kz.kbtu.sf.findmypet.dto.TokenUser;
import kz.kbtu.sf.findmypet.response.AuthResponse;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET_KEY = "FINDMYPETSECRET"; // make sure this is at least 256 bits
    private static final long EXPIRATION = 1000 * 60 * 60 * 48; // 48 hours

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(TokenUser user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("id", user.getId());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public AuthResponse authResponseFromToken(String token) {
        return new AuthResponse(token);
    }

    public TokenUser verifyToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return TokenUser.builder()
                    .id(claims.get("id", Long.class))
                    .username(claims.getSubject())
                    .role(claims.get("role", String.class))
                    .build();
        } catch (JwtException e) {
            return null; // log error if needed
        }
    }
}
