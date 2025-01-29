package com.securenotes.Securing_notes.service.service.impl;


import com.securenotes.Securing_notes.dtos.UserDTO;
import com.securenotes.Securing_notes.models.AppRole;
import com.securenotes.Securing_notes.models.Role;
import com.securenotes.Securing_notes.models.User;
import com.securenotes.Securing_notes.repositories.RoleRepository;
import com.securenotes.Securing_notes.repositories.UserRepository;
import com.securenotes.Securing_notes.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;




@Service

public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void updateUserRole(Long userId, String roleName) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        AppRole appRole = AppRole.valueOf(roleName);
        Role role = roleRepository.findByRoleName(appRole)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public UserDTO getUserById(Long id) {
      User user=userRepository.findById(id).orElseThrow();
       // User user = userRepository.findById(id).orElseThrow();

        return convertToDto(user);
    }


    private UserDTO convertToDto(User user) {
        return new UserDTO(user); // Passing the entire User object to the constructor
    }


}
