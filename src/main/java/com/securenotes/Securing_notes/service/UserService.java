package com.securenotes.Securing_notes.service;


import com.securenotes.Securing_notes.dtos.UserDTO;
import com.securenotes.Securing_notes.models.User;


import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);


    User findByUsername(String username);
}
