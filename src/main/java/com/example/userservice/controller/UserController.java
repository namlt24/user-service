package com.example.userservice.controller;

import com.example.userservice.dto.RoleDTO;
import com.example.userservice.dto.UserDTO;

import com.example.userservice.model.User;
import com.example.userservice.service.RoleService;
import com.example.userservice.service.UserService;
import com.example.userservice.util.Const;
import com.example.userservice.util.DataUtil;
import com.example.userservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.security.auth.login.LoginException;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/listAllUserInfo")
    public List<UserDTO> listAllActiveUserInfo() {
        return userService.getListUserFullInfo();
    }

    @GetMapping("/getAllRoles")
    public List<RoleDTO> getAllRoles() {
        return userService.getAllRoles();
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) throws LoginException {
        User newUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public String offUser(@PathVariable("id") Long id) throws LoginException {
        UserDTO userDTO = userService.offUser(id);
        return userDTO != null ? "Xóa thành công người dùng "+userDTO.getStaffCode() : "Lỗi không tìm thấy người dùng";
    }
    @GetMapping("/{id}")
    public UserDTO retriveUser(@PathVariable("id") Long id) throws LoginException{
        if (DataUtil.safeEqual(id,-1)){
            return new UserDTO();
        }
        return userService.findUserFullInfoById(id);
    }

}
