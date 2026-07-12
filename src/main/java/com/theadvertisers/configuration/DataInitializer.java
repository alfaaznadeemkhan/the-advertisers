package com.theadvertisers.configuration;

import com.theadvertisers.entity.User;
import com.theadvertisers.enums.Role;
import com.theadvertisers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {

            User admin = new User();

            admin.setName("Administrator");
            admin.setUsername("admin");
            admin.setEmail("admin@theadvertisers.in");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);
            admin.setEnabled(true);
            admin.setAccountNonExpired(true);
            admin.setAccountNonLocked(true);
            admin.setCredentialsNonExpired(true);

            userRepository.save(admin);

            System.out.println("======================================");
            System.out.println("Default Admin Created Successfully");
            System.out.println("Username : admin");
            System.out.println("Password : admin123");
            System.out.println("======================================");

        }

    }
}