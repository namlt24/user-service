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
    private Long mapUserRoleId;
    @Column(name = "user_id",length = 10)
    private Long UserId;
    @Column(name = "role_id",length = 10)
    private Long RoleId;

    public MapUserRole() {
    }

    public MapUserRole(Long mapUserRoleId, Long userId, Long roleId) {
        this.mapUserRoleId = mapUserRoleId;
        UserId = userId;
        RoleId = roleId;
    }

    public Long getMapUserRoleId() {
        return mapUserRoleId;
    }

    public void setMapUserRoleId(Long mapUserRoleId) {
        this.mapUserRoleId = mapUserRoleId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }
}
