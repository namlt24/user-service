package com.example.userservice.repo;

import com.example.userservice.model.MapUserRole;

import java.util.List;

public interface MapUserRoleRepoCustom {
    List<MapUserRole> getListRolesByUserId(Long id);
}
