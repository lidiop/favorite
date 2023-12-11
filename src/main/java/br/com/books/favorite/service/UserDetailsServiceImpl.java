package br.com.books.favorite.service;

import br.com.books.favorite.entity.User;
import br.com.books.favorite.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
//public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
    public User loadUserByUsername(String email) {
//    public User loadUserByUsername(String email) throws UsernameNotFoundException {
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

//        if (user == null) {
//            throw new UsernameNotFoundException("Usuário não encontrado: " + email);
//        }
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .email(user.getUsername())
//                .password(user.getPassword())
//                .roles(user.getRoles().toArray(new String[0]))
//                .build();
        return user;
    }
}

