package lk.ijse.crop_managemennt_backend.util;

import lk.ijse.crop_managemennt_backend.dto.VehicleDTO;
import lk.ijse.crop_managemennt_backend.entity.CropEntity;
import lk.ijse.crop_managemennt_backend.entity.EquipmentEntity;
import lk.ijse.crop_managemennt_backend.entity.VehicleEntity;
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
    public VehicleDTO convertToVehicleDTO(VehicleEntity vehicle){
        return modelMapper.map(vehicle, VehicleDTO.class);
    }
    public VehicleEntity convertToVehicleEntity(VehicleDTO dto){
        return modelMapper.map(dto, VehicleEntity.class);
    }
//    public List<VehicleDTO> convertVehicleToDTOList(List<VehicleEntity> vehicles){
//        return modelMapper.map(vehicles, new TypeToken<List<VehicleDTO>>(){}.getType());
//    }

//    //Equipment and DTO
//    public EquipmentDTO convertToEquipmentDTO(EquipmentEntity equipment){return modelMapper.map(equipment, EquipmentDTO.class);}
//    public EquipmentEntity convertToEquipmentEntity(EquipmentDTO dto){return modelMapper.map(dto, EquipmentEntity.class);}
//    public List<EquipmentDTO> convertEquipmentToDTOList(List<EquipmentEntity> equipment){
//        return modelMapper.map(equipment, new TypeToken<List<EquipmentDTO>>(){}.getType());
//    }
//
//    //Crop and DTO
//    public CropDTO convertToCropDTO(CropEntity crop){return modelMapper.map(crop, CropDTO.class);}
//    public CropEntity convertToCropEntity(CropDTO dto){return modelMapper.map(dto, CropEntity.class);}
//    public List<CropDTO> convertCropToDTOList(List<CropEntity> crop){
//        return modelMapper.map(crop, new TypeToken<List<CropDTO>>(){}.getType());
//    }
}