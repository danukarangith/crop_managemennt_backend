package lk.ijse.crop_managemennt_backend.service.impl;

import lk.ijse.crop_managemennt_backend.dao.UserDao;
import lk.ijse.crop_managemennt_backend.dto.UserDTO;
import lk.ijse.crop_managemennt_backend.entity.UserEntity;
import lk.ijse.crop_managemennt_backend.jwtModels.JWTResponse;
import lk.ijse.crop_managemennt_backend.jwtModels.SignIn;
import lk.ijse.crop_managemennt_backend.service.AuthenticationService;
import lk.ijse.crop_managemennt_backend.service.JWTService;
import lk.ijse.crop_managemennt_backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDao userDao;
    private final JWTService jwtService;
    private final Mapping mapping;
    private final PasswordEncoder passwordEncoder;
    //utils
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var userByEmail = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(userByEmail);
        return JWTResponse.builder().token(generatedToken).build() ;
    }


    @Override
    public JWTResponse signUp(UserDTO userDTO) {
        UserEntity user = mapping.convertToUserEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userDao.save(user);
        var genToken = jwtService.generateToken(savedUser);
        return JWTResponse.builder().token(genToken).build();
    }

    @Override
    public JWTResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity =
                userDao.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.refreshToken(userEntity);
        return JWTResponse.builder().token(refreshToken).build();
    }
}
