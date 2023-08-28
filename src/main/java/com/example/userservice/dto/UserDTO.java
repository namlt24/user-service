package com.example.userservice.dto;

import jakarta.persistence.Column;

import java.util.List;

public class UserDTO {
    private Long userId;
    private String staffCode;
    private String password;
    private String firstName;
    private String lastName;
    private String photos;
    private String status;
    private List<RoleDTO> listRoles;

    public UserDTO() {
    }

    public UserDTO(String staffCode, String password, String firstName, String lastName, String photos, String status, List<RoleDTO> listRoles) {
        this.staffCode = staffCode;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photos = photos;
        this.status = status;
        this.listRoles = listRoles;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RoleDTO> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<RoleDTO> listRoles) {
        this.listRoles = listRoles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
