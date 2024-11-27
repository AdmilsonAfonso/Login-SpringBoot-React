package com.para.todos.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.para.todos.user.Model.Usuario;

public interface Repository extends JpaRepository<Usuario,Integer>{

    Usuario findByEmail(String email);
    
}
