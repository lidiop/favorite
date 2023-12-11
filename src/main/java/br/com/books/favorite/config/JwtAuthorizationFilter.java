//package br.com.books.favorite.config;
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//                                    FilterChain chain) throws IOException, ServletException {
//        String token = jwtTokenProvider.resolveToken(request);
//
//        if (token != null && jwtTokenProvider.validateToken(token)) {
//            Claims claims = jwtTokenProvider.extractClaims(token);
//            String username = claims.getSubject();
//            List<String> roles = claims.get("roles", List.class);
//
//            if (username != null) {
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//                List<SimpleGrantedAuthority> authorities = roles.stream()
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//}
