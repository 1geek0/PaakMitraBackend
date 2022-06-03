package com.g1ee0k.paak_mitra_api.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtUtils {
    private String jwtSecret = "+ivj2389fjn238904mfnv0249jf2en9823jf2389fn289ng289hg2g8hj289034bg24890gn248ng2489+ng24hg82hf1390=";
    private String refreshSecret = "+dui2eqbnvu789w2ebnv7892nf230fhj238fjn9238fn2=";
    private int jwtExpirationMs = 1000 * 60 * 60 * 2; // 2 hrs

    private final byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
    private final SecretKey key = Keys.hmacShaKeyFor(keyBytes);

    private final byte[] refreshKeyBytes = Decoders.BASE64.decode(refreshSecret);
    private final SecretKey refreshKey = Keys.hmacShaKeyFor(refreshKeyBytes);

    private final JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    private final JwtParser jwtRefreshParser = Jwts.parserBuilder().setSigningKey(refreshKey).build();

    public String generateJwtToken(String email, String id) {
        HashMap<String, String> claimMap = new HashMap<>();
        claimMap.put("id", id);
        return Jwts.builder()
                .setClaims(claimMap)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000L * 60 * 60 * 24 * 365)) // 1 year expiration
                .signWith(refreshKey)
                .compact();
    }

    public String getUserNameFromJwt(String token) {
        System.out.println(jwtParser.parseClaimsJws(token).getBody().getSubject());
        return jwtParser.parseClaimsJws(token).getBody().getSubject();
    }

    public String getUserIdFromJwt(String token) {
        System.out.println(jwtParser.parseClaimsJws(token).getBody());
        return jwtParser.parseClaimsJws(token).getBody().get("id", String.class);
    }

    public void validateJwtToken(String authToken) {
        jwtParser.parseClaimsJws(authToken);
    }
}
