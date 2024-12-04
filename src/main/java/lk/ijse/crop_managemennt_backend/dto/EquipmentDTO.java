package lk.ijse.crop_managemennt_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lk.ijse.crop_managemennt_backend.customObj.EquipmentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EquipmentDTO implements SuperDTO, EquipmentResponse {
    @NotBlank(message = "Equipment ID cannot be blank")
    private String equipmentId;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Type cannot be blank")
    private String type;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    @NotBlank(message = "Staff ID cannot be blank")
    private String staffId;

    @NotBlank(message = "Field code cannot be blank")
    private String fieldCode;
}
