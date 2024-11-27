package com.para.todos.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.para.todos.user.Model.Usuario;
import com.para.todos.user.Repository.Repository;
import com.para.todos.user.Service.ServiceDTO.ServiceDTO;

@org.springframework.stereotype.Service
public class Service implements ServiceImpl{
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private Repository repository;
    public Service(Repository repository){
        this.repository = repository;
    }

    @Override
    public Usuario salvar(ServiceDTO serviceDTO) {

        Usuario usuario = new Usuario(serviceDTO.getEmail(),passwordEncoder.encode(serviceDTO.getPassword()),serviceDTO.getRole());
            return repository.save(usuario);
            
    }

    @Override
    public Usuario buscarEmail(String email) {
        return repository.findByEmail(email);   
    }
}
