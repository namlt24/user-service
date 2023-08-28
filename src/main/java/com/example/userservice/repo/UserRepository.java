package com.example.userservice.repo;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
public interface UserRepository extends JpaRepository<User, Long>, UserRepoCustom {

}
