package lk.ijse.crop_managemennt_backend.controller;

import lk.ijse.crop_managemennt_backend.customObj.UserResponse;
import lk.ijse.crop_managemennt_backend.dto.UserDTO;
import lk.ijse.crop_managemennt_backend.exception.DataPersistFailedException;
import lk.ijse.crop_managemennt_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor

public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody UserDTO user){
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try{
                userService.saveUser(user);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getSelectedUser(@PathVariable("email") String email){
        return userService.getSelectedUser(email);
    }

}
