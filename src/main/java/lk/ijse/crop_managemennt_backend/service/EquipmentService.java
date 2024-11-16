package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.dto.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);
    List<EquipmentDTO> getAllEquipments();
}
