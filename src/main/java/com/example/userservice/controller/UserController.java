package com.example.userservice.controller;

import com.example.userservice.dto.RoleDTO;
import com.example.userservice.dto.UserDTO;

import com.example.userservice.model.User;
import com.example.userservice.service.RoleService;
import com.example.userservice.service.UserService;
import com.example.userservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.security.auth.login.LoginException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/listAllActiveUserInfo")
    public List<UserDTO> listAllActiveUserInfo(){
      return userService.getListUserFullInfo();
    }

    @GetMapping("/getAllRoles")
    public List<RoleDTO> getAllRoles(){
        return userService.getAllRoles();
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) throws LoginException {
        User newUser = userService.saveUser(userDTO);
       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
