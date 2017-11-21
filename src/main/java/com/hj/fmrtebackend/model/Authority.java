package com.hj.fmrtebackend.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AuthorityRole authorityRole;
    
    @Override
    public String getAuthority() {
        return authorityRole.getRole().name();
    }

}
