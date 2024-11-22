package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.dto.UserDTO;
import lk.ijse.crop_managemennt_backend.jwtModels.JWTResponse;
import lk.ijse.crop_managemennt_backend.jwtModels.SignIn;

public interface AuthenticationService {
    JWTResponse signIn(SignIn signIn);
    JWTResponse signUp(UserDTO userDTO);
    JWTResponse refreshToken(String accessToken);
}
