package com.para.todos.user.AUTH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.para.todos.user.Model.Usuario;
import com.para.todos.user.Repository.Repository;

@Service
public class CustomeUserDetailServcie implements UserDetailsService {

    @Autowired
    private Repository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
            Usuario usuario = repository.findByEmail(username);
                if (usuario ==null) {
                    throw new UsernameNotFoundException("USARIOA NAO ENCONTRADO"+username);
                }
            return new CustomeUserDetail(usuario);
    }
    
}
