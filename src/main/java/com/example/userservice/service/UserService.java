package com.example.userservice.service;


import com.example.userservice.dto.RoleDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.MapUserRole;
import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import com.example.userservice.repo.UserRepository;
import com.example.userservice.util.Const;
import com.example.userservice.util.DataUtil;
import com.example.userservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MapUserRoleService mapUserRoleService;

    public List<UserDTO> getListUserFullInfo() {
        List<UserDTO> listUserActiveFullInfo = listAllUserByStatus(Const.STATUS.ACTIVE);
        for (UserDTO userDTO : listUserActiveFullInfo) {
            List<RoleDTO> listRoleOfUser = roleService.findListRoleByUserId(userDTO.getUserId());
            userDTO.setListRoles(listRoleOfUser);
        }
        return listUserActiveFullInfo;
    }

    public List<RoleDTO> getAllRoles() {
        List<RoleDTO> allRoles = roleService.findAllRoles();
        return allRoles;
    }

    public User saveUser(UserDTO userDTO) throws LoginException {
        if (userDTO.getStaffCode().isEmpty()) {
            throw new LoginException("Thiếu mã thông tin nhân sự");
        }
        if (userDTO.getFirstName().isEmpty()) {
            throw new LoginException("Thiếu họ");
        }
        if (userDTO.getLastName().isEmpty()) {
            throw new LoginException("Thiếu tên");
        }
        if (userDTO.getPassword().isEmpty()) {
            throw new LoginException("Thiếu mật khẩu");
        }

        User savedUser = userRepository.save(ObjectMapperUtils.map(userDTO,User.class));
        if (savedUser!=null){
            if (userDTO.getListRoles()!=null){
                // Thực hiện lưu vào bảng mapping
                for (RoleDTO role: userDTO.getListRoles()){
                    MapUserRole mapUserRole = new MapUserRole();
                    mapUserRole.setUserId(savedUser.getUserId());
                    mapUserRole.setRoleId(role.getRoleId());

                }


            }
        }
        return user;
    }

    public List<UserDTO> listAllUserByStatus(String status) {
        List<User> listUserByStatus = userRepository.listAllUserByStatus(status);
        List<UserDTO> resultList = ObjectMapperUtils.mapAll(listUserByStatus, UserDTO.class);
        return resultList;
    }
}
