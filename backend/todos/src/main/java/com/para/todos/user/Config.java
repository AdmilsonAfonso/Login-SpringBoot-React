package com.para.todos.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import com.para.todos.user.AUTH.CustomeUserDetail;
import com.para.todos.user.AUTH.CustomeUserDetailServcie;

@Configuration
@EnableWebSecurity
public class Config {
    
    @Autowired
    private CustomeUserDetailServcie customeUserDetailServcie;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings({"remove","deprecation"})
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(c->c.disable())
        .authorizeRequests()
        .requestMatchers("/**").permitAll()
        .and()
        .logout().permitAll();

        return http.build();
    }


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customeUserDetailServcie).passwordEncoder(passwordEncoder());
    }
}
