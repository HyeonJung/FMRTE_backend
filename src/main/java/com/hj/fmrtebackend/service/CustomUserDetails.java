package com.hj.fmrtebackend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.hj.fmrtebackend.model.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public CustomUserDetails(String username, String password,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUserDetails(Users user) {
        super(user.getUsername(), user.getPassword(), user.isAccountNonExpired(),
                user.isAccountNonLocked(), user.isCredentialsNonExpired(), user.isEnabled(),
                authorities(user));

        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }

    
    private static Collection<? extends GrantedAuthority> authorities(Users user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        user.getAuthorities().forEach(a -> {
            authorities.add(new SimpleGrantedAuthority(a.getAuthority()));
        });
        return authorities;
    }

    public CustomUserDetails(String username, String password,
            Collection<? extends GrantedAuthority> authorities, String name) {
        super(username, password, authorities);
        this.username = username;
        this.name = name;
    }

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
