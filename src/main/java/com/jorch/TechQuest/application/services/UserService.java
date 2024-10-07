package com.jorch.TechQuest.application.services;

import com.jorch.TechQuest.application.dto.request.AuthRequest;
import com.jorch.TechQuest.application.dto.request.RegisterRequest;
import com.jorch.TechQuest.application.dto.response.AuthResponse;
import com.jorch.TechQuest.application.exceptions.InvalidCredentialsException;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.entity.UserEntity;
import com.jorch.TechQuest.application.infrastructure.adapter.persistence.repository.UserRepository;
import com.jorch.TechQuest.application.infrastructure.jwt.JwtUtil;
import com.jorch.TechQuest.domain.exceptions.UserAlreadyExistsException;
import com.jorch.TechQuest.domain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Cambiado a PasswordEncoder

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public UserEntity register(RegisterRequest registerDTO) {
        // Verificar si el usuario ya existe
        if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        // Crear un nuevo usuario
        UserEntity user = new UserEntity();
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(Role.valueOf(registerDTO.getRole()));
        user.setActive(registerDTO.isActive()); // Usar el valor proporcionado en el DTO

        return userRepository.save(user);
    }



    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            // Autenticar las credenciales del usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );

            // Generar JWT
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtUtil.generateToken(userDetails.getUsername());

            return new AuthResponse(jwt);
        } catch (Exception e) { // Manejar errores de autenticación
            throw new InvalidCredentialsException("Incorrect Credentials");
        }
    }
}
