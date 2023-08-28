package com.example.userservice.service;

import com.example.userservice.dto.RoleDTO;
import com.example.userservice.model.Role;
import com.example.userservice.repo.RoleRepository;
import com.example.userservice.util.DataUtil;
import com.example.userservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    public RoleRepository roleRepository;

    public List<RoleDTO> findListRoleByUserId(Long userId){
        if (DataUtil.isNullOrEmpty(userId)) return null;
        List<Role> roles = roleRepository.findListRoleByUserId(userId);
        List<RoleDTO> result = ObjectMapperUtils.mapAll(roles, RoleDTO.class);
        return result;
    }

}
