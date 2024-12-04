package lk.ijse.crop_managemennt_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lk.ijse.crop_managemennt_backend.customObj.VehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleDTO implements SuperDTO, VehicleResponse {
    @NotBlank(message = "Vehicle Code cannot be blank")
    private String vehicleCode;

    @NotBlank(message = "License Plate Number cannot be blank")
    @Size(min = 1, max = 15, message = "License Plate Number must be between 1 and 15 characters")
    private String licensePlateNumber;

    @NotBlank(message = "Vehicle Category cannot be blank")
    private String vehicleCategory;

    @NotBlank(message = "Fuel Type cannot be blank")
    private String fuelType;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    @NotBlank(message = "Staff ID cannot be blank")
    private String staffId;

    @Size(max = 500, message = "Remarks can be at most 500 characters")
    private String remarks;
}
