package com.rest.crudemployee.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    

    // Código não mais necessário, pois os usuários e seus cargos, agora são definidos no próprio banco de dados
    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager(){

    //     UserDetails john = User.builder()
    //                         .username("john")
    //                         .password("{noop}test123")
    //                         .roles("EMPLOYEE")
    //                         .build();

    //     UserDetails mary = User.builder()
    //                         .username("mary")
    //                         .password("{noop}test123")
    //                         .roles("EMPLOYEE", "MANAGER")
    //                         .build();
        
    //     UserDetails susan = User.builder()
    //                         .username("susan")
    //                         .password("{noop}test123")
    //                         .roles("EMPLOYEE", "MANAGER", "ADMIN")
    //                         .build();

    //     return new InMemoryUserDetailsManager(john, mary, susan);

    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> 
                configurer.requestMatchers(HttpMethod.GET, "api/employees", "api/employees/**").hasRole("EMPLOYEE")
                          .requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
                          .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
                          .requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
                );


        http.httpBasic(Customizer.withDefaults());

        http.csrf(csfr -> csfr.disable());

        return http.build();

    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
}
