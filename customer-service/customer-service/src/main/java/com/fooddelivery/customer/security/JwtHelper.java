package com.fooddelivery.customer.security;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtHelper {
	
//	private static final SecretKey key = Keys.hmacShaKeyFor(
//	        "mysecretkeymysecretkeymysecretkey12345".getBytes()
//	);

	private static Claims extractAllClaims(String token) {
	    return Jwts.parserBuilder()
	            .setSigningKey(key)
	            .build()
	            .parseClaimsJws(token)
	            .getBody();
	}
	
	 // Secret Key (minimum 32 characters)
    private static final String SECRET_KEY =
            "mySecretKeyForJwtAuthentication123456789";

    // Token Expiry (24 Hours)
    private static final long JWT_EXPIRATION =
            1000 * 60 * 60 * 24;

    private static final SecretKey key =
            Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Generate JWT Token
    public static String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract Username
    public static String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    // Extract Expiration Date
    public static Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }

    // Generic Claim Extraction
    public static <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver) {

        Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    // Parse Token
//    private static Claims extractAllClaims(String token) {
//
//        return ((Object) Jwts.parser())
//                .verifyWith((javax.crypto.SecretKey) key)
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }

    // Check Expired
    public static boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    // Validate Token
    public static boolean validateToken(
            String token,
            String username) {

        return username.equals(extractUsername(token))
                && !isTokenExpired(token);
    }



}
