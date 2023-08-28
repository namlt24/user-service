package com.example.userservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "map_user_role")
public class MapUserRole {
    @Id
    @Column(name = "map_user_role_id",length = 10)
    private Integer mapUserRoleId;
    @Column(name = "user_id",length = 10)
    private Integer UserId;
    @Column(name = "role_id",length = 10)
    private Integer RoleId;

    public MapUserRole() {
    }

    public MapUserRole(Integer mapUserRoleId, Integer userId, Integer roleId) {
        this.mapUserRoleId = mapUserRoleId;
        UserId = userId;
        RoleId = roleId;
    }

    public Integer getMapUserRoleId() {
        return mapUserRoleId;
    }

    public void setMapUserRoleId(Integer mapUserRoleId) {
        this.mapUserRoleId = mapUserRoleId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }
}
