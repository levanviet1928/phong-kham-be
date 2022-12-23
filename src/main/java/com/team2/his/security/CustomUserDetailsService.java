package com.team2.his.security;

import com.team2.his.entity.Account;
import com.team2.his.repostiris.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String loginId)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Account user = userRepository.findByUserName(loginId)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + loginId)
                );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(UUID id) {
        Account user = userRepository.findByAccountId(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        return UserPrincipal.create(user);
    }
}
