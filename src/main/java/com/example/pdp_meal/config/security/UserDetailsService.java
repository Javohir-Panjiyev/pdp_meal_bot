package com.example.pdp_meal.config.security;


import com.example.pdp_meal.model.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AuthUser user = authUserRepository.findAuthUserByUsername(username)
//            2323    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return new UserDetails(user);
        return new UserDetails(new AuthUser());
    }

    public UserDetails getSession() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication();
    }
}
