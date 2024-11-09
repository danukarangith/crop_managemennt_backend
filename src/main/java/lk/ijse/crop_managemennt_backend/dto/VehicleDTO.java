package lk.ijse.crop_managemennt_backend.dto;

import lk.ijse.crop_managemennt_backend.customObj.VehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleDTO implements SuperDTO, VehicleResponse {
    private String vehicleCode;
    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;
    private String status;
    private String staffId;
    private String remarks;
}
