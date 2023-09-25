package com.example.userservice.service;


import com.example.userservice.dto.RoleDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.MapUserRole;
import com.example.userservice.model.User;
import com.example.userservice.repo.UserRepository;
import com.example.userservice.util.Const;
import com.example.userservice.util.DataUtil;
import com.example.userservice.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MapUserRoleService mapUserRoleService;


    public List<UserDTO> getListUserFullInfo() {
        List<UserDTO> listUserActiveFullInfo = listAllUserByStatus(null);
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
        User savedUser = new User();
        if (DataUtil.safeEqual(userDTO.getStatus(), "true")) {
            userDTO.setStatus("1");
        } else {
            userDTO.setStatus("0");
        }
        if (DataUtil.isNullOrEmpty(userDTO.getStaffCode())) {
            throw new LoginException("Thiếu thông tin mã thông tin nhân sự");
        }
        if (DataUtil.isNullOrEmpty(userDTO.getFirstName())) {
            throw new LoginException("Thiếu thông tin họ");
        }
        if (DataUtil.isNullOrEmpty(userDTO.getLastName())) {
            throw new LoginException("Thiếu thông tin tên");
        }
        if (DataUtil.isNullOrEmpty(userDTO.getPassword())) {
            throw new LoginException("Thiếu thông tin mật khẩu");
        }
        List<User> listAllUserByStatus = userRepository.listAllUserByStatus(Const.STATUS.ACTIVE);
        List<String> lstStaffCode = listAllUserByStatus.
                stream().map(x -> x.getStaffCode()).collect(Collectors.toList());
        List<Long> lstStaffIds = listAllUserByStatus.
                stream().map(x -> x.getUserId()).collect(Collectors.toList());

        if (DataUtil.safeEqual(userDTO.getUserId(), -1)) {
            //Thêm mới
            if (lstStaffCode.contains(userDTO.getStaffCode())
            ) {
                throw new LoginException("Mã thông tin nhân sự đã tồn tại trên hệ thống");
            }
        } else {
            //Cập nhật
            if (lstStaffCode.contains(userDTO.getStaffCode()) &&
                    !lstStaffIds.contains(userDTO.getUserId())) {
                throw new LoginException("Mã thông tin nhân sự đã tồn tại trên hệ thống");
            }
        }

        // Validate check trùng staffCode


        User user = userRepository.findByUserId(userDTO.getUserId());
        if (user!=null){
            user.setStaffCode(userDTO.getStaffCode());
            user.setPassword(userDTO.getPassword());
            user.setPhotos(userDTO.getPhotos());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setStatus(userDTO.getStatus());
            savedUser = userRepository.save(user);
        }else{
            User newUser =new User();
            newUser.setStaffCode(userDTO.getStaffCode());
            newUser.setPassword(userDTO.getPassword());
            newUser.setPhotos(userDTO.getPhotos());
            newUser.setFirstName(userDTO.getFirstName());
            newUser.setLastName(userDTO.getLastName());
            newUser.setStatus(userDTO.getStatus());
            savedUser = userRepository.save(newUser);
        }

        if (savedUser != null) {
            //B1. Lấy danh sách listRoles trong DB và off đi
            List<MapUserRole> mapUserRoleList = mapUserRoleService.getListRolesByUserId(userDTO.getUserId());

            if (userDTO.getListRoles() != null) {
                if (mapUserRoleList!=null){
                    for (MapUserRole mapUserRole:mapUserRoleList){
                        mapUserRole.setStatus("0");
                        mapUserRoleService.saveMapUserRole(mapUserRole);
                    }
                }
                for (RoleDTO role : userDTO.getListRoles()) {
                    MapUserRole mapUserRole = new MapUserRole();
                    mapUserRole.setUserId(savedUser.getUserId());
                    mapUserRole.setRoleId(role.getRoleId());
                    mapUserRole.setStatus("1");
                    mapUserRoleService.saveMapUserRole(mapUserRole);
                }
            }
        }


        return savedUser;
    }

    public List<UserDTO> listAllUserByStatus(String status) {
        List<User> listUserByStatus = userRepository.listAllUserByStatus(status);
        List<UserDTO> resultList = ObjectMapperUtils.mapAll(listUserByStatus, UserDTO.class);
        return resultList;
    }

    public UserDTO offUser(Long id) {
        User user = userRepository.findByUserId(id);
        if (user != null) {
            user.setStatus("0");
            userRepository.save(user);
            return ObjectMapperUtils.map(user, UserDTO.class);
        }
        return null;
    }

    public UserDTO findUserFullInfoById(Long id) {
        List<UserDTO> listUserActiveFullInfo = listAllUserByStatus(null);
        if (listUserActiveFullInfo != null) {
            for (UserDTO userDTO : listUserActiveFullInfo) {
                if (DataUtil.safeEqual(userDTO.getUserId(), id)) {
                    List<RoleDTO> listRoleOfUser = roleService.findListRoleByUserId(userDTO.getUserId());
                    userDTO.setListRoles(listRoleOfUser);
                    return userDTO;
                }
            }
        }
        return null;
    }
}
