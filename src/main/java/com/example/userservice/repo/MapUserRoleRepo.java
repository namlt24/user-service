package com.example.userservice.repo;

import com.example.userservice.model.MapUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MapUserRoleRepo extends JpaRepository<MapUserRole,Integer>,MapUserRoleRepoCustom {

}
