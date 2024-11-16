package lk.ijse.crop_managemennt_backend.dto;

import lk.ijse.crop_managemennt_backend.customObj.UserResponse;
import lk.ijse.crop_managemennt_backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDTO implements SuperDTO, UserResponse {
    private String email;
    private String password;
    private Role role;
}
