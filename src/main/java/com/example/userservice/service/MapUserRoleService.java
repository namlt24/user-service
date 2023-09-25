package com.example.userservice.service;

import com.example.userservice.model.MapUserRole;
import com.example.userservice.repo.MapUserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapUserRoleService {
    @Autowired
    private MapUserRoleRepo mapUserRoleRepo;

    public void saveMapUserRole(MapUserRole mapUserRole){
        mapUserRoleRepo.save(mapUserRole);
    }

    public List<MapUserRole> getListRolesByUserId(Long id){
        return mapUserRoleRepo.getListRolesByUserId(id);
    }

}
