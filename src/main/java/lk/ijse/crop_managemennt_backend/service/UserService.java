package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.customObj.UserResponse;
import lk.ijse.crop_managemennt_backend.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserResponse getSelectedUser(String email);
    void updateUser(String email, UserDTO userDTO);
    void deleteUser(String email);
    UserDetailsService userDetailsService();



}

