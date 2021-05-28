package com.company.librarywebappspring.repository;

import com.company.librarywebappspring.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
