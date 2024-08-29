package com.example.library_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    //    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/edit/**").hasRole(String.valueOf(UserRole.ADMIN))
//                        .requestMatchers("/edit/**").hasRole(String.valueOf(UserRole.PUBLISHER))
//                        .requestMatchers("/delete/**").hasRole(String.valueOf(UserRole.ADMIN))
//                        .anyRequest().authenticated()
//
//                );
//        return http.build();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/edit/**").hasAnyRole("ADMIN", "PUBLISHER")
                        .requestMatchers("/delete/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
                )
                .logout(LogoutConfigurer::permitAll
                );

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user_admin = User.builder()
                .username("user_admin")
                .password(passwordEncoder().encode("Admin@123"))
                .roles("ADMIN")
                .build();

        UserDetails user_pub = User.builder()
                .username("user_publisher")
                .password(passwordEncoder().encode("Publisher@123"))
                .roles("PUBLISHER")
                .build();

        UserDetails user_read = User.builder()
                .username("user_read")
                .password(passwordEncoder().encode("Read@123"))
                .roles("READ_ONLY")
                .build();

        return new InMemoryUserDetailsManager(user_admin, user_pub, user_read);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCryptPasswordEncoder for password encoding
    }
}
