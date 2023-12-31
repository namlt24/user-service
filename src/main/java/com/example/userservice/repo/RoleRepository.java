package com.example.userservice.repo;

import com.example.userservice.dto.RoleDTO;
import com.example.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long>,RoleRepositoryCustom {

    }
