package com.para.todos.user.Service;

import com.para.todos.user.Model.Usuario;
import com.para.todos.user.Service.ServiceDTO.ServiceDTO;

public interface ServiceImpl {

    public Usuario salvar(ServiceDTO serviceDTO);
    public Usuario buscarEmail(String email);

}
