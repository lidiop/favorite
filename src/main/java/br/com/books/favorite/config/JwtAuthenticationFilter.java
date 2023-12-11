//package br.com.books.favorite.config;
//
//import io.jsonwebtoken.JwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Collections;
//
//@Component
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            // Extrair as credenciais do corpo da solicitação
//            String username = obtainUsername(request);
//            String password = obtainPassword(request);
//
//            // Criar token de autenticação com as credenciais fornecidas
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                    username, password, Collections.emptyList());
//
//            // Autenticar o usuário
//            return authenticationManager.authenticate(authenticationToken);
//        } catch (Exception e) {
//            throw new JwtException("Falha na autenticação", e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        // Se a autenticação for bem-sucedida, gerar e adicionar o token JWT à resposta
//        String token = jwtTokenProvider.createToken(authResult);
//        response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
//    }
//}
