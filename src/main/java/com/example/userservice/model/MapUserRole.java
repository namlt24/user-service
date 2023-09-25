package com.example.userservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "map_user_role")
public class MapUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_user_role_id",length = 10)
    private Long mapUserRoleId;
    @Column(name = "user_id",length = 10)
    private Long UserId;
    @Column(name = "role_id",length = 10)
    private Long RoleId;

    @Column(name = "status")
    private String status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
