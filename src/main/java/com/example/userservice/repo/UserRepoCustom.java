package com.example.userservice.repo;

import com.example.userservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepoCustom {
    public List<User> listAllUserByStatus(String status);

}
