package com.team2.his.security;

import com.team2.his.entity.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class UserPrincipal implements UserDetails {
    private UUID accountId;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(UUID accountId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Account user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
//                new SimpleGrantedAuthority(role.getRoleCd().name())
//        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getAccountId(),
                user.getUserName(),
                user.getPassword(),
                null
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accountId);
    }
}
