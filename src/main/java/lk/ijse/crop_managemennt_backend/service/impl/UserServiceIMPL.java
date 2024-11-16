package lk.ijse.crop_managemennt_backend.service.impl;

import lk.ijse.crop_managemennt_backend.dao.UserDao;
import lk.ijse.crop_managemennt_backend.dto.UserDTO;
import lk.ijse.crop_managemennt_backend.entity.UserEntity;
import lk.ijse.crop_managemennt_backend.exception.DataPersistFailedException;
import lk.ijse.crop_managemennt_backend.service.UserService;
import lk.ijse.crop_managemennt_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        var userEntity = mapping.convertToUserEntity(userDTO);
        var savedUser = userDao.save(userEntity);
        if (savedUser == null){
            throw new DataPersistFailedException("Cannot Save User");
        }
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> getAllUsers = userDao.findAll();
        return mapping.convertUserToDTOList(getAllUsers);
    }

}
