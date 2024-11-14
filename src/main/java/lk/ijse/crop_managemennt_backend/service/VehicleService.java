package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.customObj.VehicleResponse;
import lk.ijse.crop_managemennt_backend.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    VehicleResponse getSelectedVehicle(String vehicleCode);
    void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicleCode);
}
