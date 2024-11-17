package lk.ijse.crop_managemennt_backend.util;

import lk.ijse.crop_managemennt_backend.dto.*;
import lk.ijse.crop_managemennt_backend.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //    VehicleEntity and DTO
    public VehicleDTO convertToVehicleDTO(VehicleEntity vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    public VehicleEntity convertToVehicleEntity(VehicleDTO dto) {
        return modelMapper.map(dto, VehicleEntity.class);
    }

    public List<VehicleDTO> convertVehicleToDTOList(List<VehicleEntity> vehicles) {
        return modelMapper.map(vehicles, new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }

    //Equipment and DTO
    public EquipmentDTO convertToEquipmentDTO(EquipmentEntity equipment) {
        return modelMapper.map(equipment, EquipmentDTO.class);
    }

    public EquipmentEntity convertToEquipmentEntity(EquipmentDTO dto) {
        return modelMapper.map(dto, EquipmentEntity.class);
    }

    public List<EquipmentDTO> convertEquipmentToDTOList(List<EquipmentEntity> equipment) {
        return modelMapper.map(equipment, new TypeToken<List<EquipmentDTO>>() {
        }.getType());
    }


    //Staff and DTO

    public StaffEntity convertToStaffEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, StaffEntity.class);
    }
    public List<StaffDTO> convertStaffToDTOList(List<StaffEntity> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>(){}.getType());
    }
    public StaffDTO convertToStaffDTO(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity, StaffDTO.class);
    }

//user and DTO

    public UserEntity convertToUserEntity(UserDTO dto){return modelMapper.map(dto, UserEntity.class);}
    public List<UserDTO> convertUserToDTOList(List<UserEntity> user){
        return modelMapper.map(user, new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO convertToUserDTO(UserEntity user){return modelMapper.map(user, UserDTO.class);}



    public CropEntity convertToCropEntity(CropDTO dto){return modelMapper.map(dto, CropEntity.class);}
    public List<CropDTO> convertCropToDTOList(List<CropEntity> crop){
        return modelMapper.map(crop, new TypeToken<List<CropDTO>>(){}.getType());
    }
}


