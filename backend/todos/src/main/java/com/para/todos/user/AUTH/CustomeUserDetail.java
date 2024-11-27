package com.para.todos.user.AUTH;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.para.todos.user.Model.Usuario;


public class CustomeUserDetail implements UserDetails {
    
    @Autowired
    private Usuario usuario;

    public CustomeUserDetail(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(()->usuario.getRole());
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();    
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
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
       
}
