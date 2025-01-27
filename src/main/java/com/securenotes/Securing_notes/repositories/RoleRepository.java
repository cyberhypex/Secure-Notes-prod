package com.securenotes.Securing_notes.repositories;


import com.securenotes.Securing_notes.models.AppRole;
import com.securenotes.Securing_notes.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);

}

