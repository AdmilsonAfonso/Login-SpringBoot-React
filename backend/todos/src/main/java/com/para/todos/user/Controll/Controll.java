package com.para.todos.user.Controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.para.todos.user.AUTH.CustomeUserDetailServcie;
import com.para.todos.user.Model.Usuario;
import com.para.todos.user.Repository.Repository;
import com.para.todos.user.Service.Service;
import com.para.todos.user.Service.ServiceDTO.ServiceDTO;

@RestController
@RequestMapping("/usuario")
public class Controll {

    @Autowired
    private Repository repository;

    @Autowired
    private Service service;

    public Controll(Service service){
        this.service = service;
    }

    @PostMapping("/salavar")
    public void salvarU(@RequestBody ServiceDTO serviceDTO){
          service.salvar(serviceDTO);
       
    }

    @GetMapping("/buscaEmail/{email}")
    public Usuario buscarT(@PathVariable String email){
        return service.buscarEmail(email);
    }


   // @Autowired
    //  private CustomeUserDetailServcie userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody ServiceDTO serviceDTO) {
    
    try {
        // Validação de entrada
        if (serviceDTO.getEmail() == null || serviceDTO.getEmail().isEmpty() || 
            serviceDTO.getPassword() == null || serviceDTO.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail e senha são obrigatórios");
        }

        // Buscar usuário pelo e-mail
        Usuario usuario = repository.findByEmail(serviceDTO.getEmail().trim());
        if (usuario == null) {
            // Mensagem genérica para segurança
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        // Verificar a senha
        if (!passwordEncoder.matches(serviceDTO.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        // Retornar sucesso
        return ResponseEntity.ok("Login bem-sucedido");
    } catch (Exception e) {
        // Log do erro para depuração (opcional, mas importante em produção)
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar login");
    }
}


}
