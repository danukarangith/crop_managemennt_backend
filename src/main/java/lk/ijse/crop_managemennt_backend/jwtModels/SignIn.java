package lk.ijse.crop_managemennt_backend.jwtModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SignIn {
    private String email;
    private String password;
}
