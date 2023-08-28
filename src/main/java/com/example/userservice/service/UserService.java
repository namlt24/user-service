package com.example.userservice.service;


import com.example.userservice.dto.RoleDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.User;
import com.example.userservice.repo.RoleRepository;
import com.example.userservice.repo.UserRepository;
import com.example.userservice.util.Const;
import com.example.userservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public List<UserDTO> getListUserFullInfo() {
        List<UserDTO> listUserActiveFullInfo = listAllUserByStatus(Const.STATUS.ACTIVE);
        for (UserDTO userDTO: listUserActiveFullInfo){
            List<RoleDTO> listRoleOfUser = roleService.findListRoleByUserId(userDTO.getUserId());
            userDTO.setListRoles(listRoleOfUser);
        }
        return listUserActiveFullInfo;
    }

    public List<UserDTO> listAllUserByStatus(String status){
        List<User> listUserByStatus = userRepository.listAllUserByStatus(status);
        List<UserDTO> resultList = ObjectMapperUtils.mapAll(listUserByStatus,UserDTO.class);
        return resultList;
    }
}
