package com.example.userservice.repo;

import com.example.userservice.model.Role;

import java.util.List;

public interface RoleRepositoryCustom {
    public List<Role> findListRoleByUserId(Long userId);


}
