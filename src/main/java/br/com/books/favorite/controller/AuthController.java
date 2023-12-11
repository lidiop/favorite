package br.com.books.favorite.controller;

import br.com.books.favorite.entity.User;
import br.com.books.favorite.repository.UserRepository;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class AuthController {
//    private final AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
//    private final String jwtSecret;

//    public AuthController(AuthenticationManager authenticationManager,
//                          UserRepository userRepository,
//                          @Value("${jwt.secret}") String jwtSecret) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.jwtSecret = jwtSecret;
//    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .claim("roles", userDetails.getAuthorities())
//                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora em milissegundos
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
    }
}
