package com.example.userservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false,unique = true)
    private Long userId;
    @Column(length = 128)
    private String staffCode;
    @Column(length = 64,nullable = false)
    private String password;
    @Column(name = "first_name",length = 45,nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 45,nullable = false)

    private String lastName;
    @Column(length = 64)
    private String photos;
    private String status;

    public User() {
    }

    public User(String staffCode, String password, String firstName, String lastName, String photos, String status) {
        this.staffCode = staffCode;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photos = photos;
        this.status = status;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
