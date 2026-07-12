package com.theadvertisers.configuration;

import com.theadvertisers.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

                .authenticationProvider(authenticationProvider())

                .authorizeHttpRequests(auth -> auth

                        // Public URLs
                        .requestMatchers(
                                "/",
                                "/home",
                                "/about",
                                "/services",
                                "/portfolio",
                                "/contact",
                                "/contact/submit",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/logo/**",
                                "/uploads/**",
                                "/webjars/**",
                                "/admin/css/**",
                                "/admin/js/**"

                        ).permitAll()

                        // Admin URLs
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")

                        .anyRequest()
                        .authenticated()

                )

                .formLogin(login -> login

                        .loginPage("/admin/login")

                        .loginProcessingUrl("/admin/login")

                        .defaultSuccessUrl("/admin/dashboard", true)

                        .failureUrl("/admin/login?error")

                        .permitAll()

                )

                .logout(logout -> logout

                        .logoutUrl("/logout")

                        .logoutSuccessUrl("/admin/login?logout")

                        .invalidateHttpSession(true)

                        .deleteCookies("JSESSIONID")

                        .permitAll()

                );

        return http.build();
    }

}