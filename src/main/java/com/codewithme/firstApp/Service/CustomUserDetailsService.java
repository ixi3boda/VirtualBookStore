package com.codewithme.firstApp.Service;

import org.springframework.security.core.userdetails.User;
import com.codewithme.firstApp.Repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.codewithme.firstApp.Model.User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(
                user.getUserName(),
                user.getUserPassword(),  // Make sure this is the encoded password
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))  // Correct authority
        );
    }
}
