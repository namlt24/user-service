package com.example.userservice.repo;

import com.example.userservice.dto.RoleDTO;
import com.example.userservice.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository {
    public List<Role> findListRoleByUserId(Long userId);

    }
