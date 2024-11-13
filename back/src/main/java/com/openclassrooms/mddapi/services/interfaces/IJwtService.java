package com.openclassrooms.mddapi.services.interfaces;


import com.openclassrooms.mddapi.models.UserPrincipal;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

public interface IJwtService {

    String generateToken(String username);

    String extractEmail(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimResolver);

    Claims extractAllClaims(String token);

    boolean hasTokenNotExpiredAndExistingUser(String token, UserPrincipal userPrincipal);

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);

    SecretKey getKey();
}
