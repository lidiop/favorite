//package br.com.books.favorite.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//
//    private final String secretKey = "bookstore-secret-key";
//    private final long validityInMilliseconds = 60000; // 1 minuto
//
//    public String createToken(Authentication authentication) {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMilliseconds);
//
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .claim("roles", userDetails.getAuthorities())
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jws<Claims> claims = Jwts.parserBuilder()
//                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
//                    .build()
//                    .parseClaimsJws(token);
//
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Claims extractClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}
