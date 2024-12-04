package lk.ijse.crop_managemennt_backend.dto;

import jakarta.validation.constraints.*;
import lk.ijse.crop_managemennt_backend.customObj.CropResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CropDTO implements SuperDTO, CropResponse {
    @NotBlank(message = "Crop code cannot be blank")
    private String cropCode;

    @NotBlank(message = "Common name cannot be blank")
    @Size(min = 2, max = 100, message = "Common name must be between 2 and 100 characters")
    private String cropCommonName;

    @NotBlank(message = "Scientific name cannot be blank")
    @Size(min = 2, max = 100, message = "Scientific name must be between 2 and 100 characters")
    private String cropScientificName;


    private String cropImage;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @NotBlank(message = "Crop season cannot be blank")
    private String cropSeason;

    @NotBlank(message = "Field code cannot be blank")
    private String fieldCode;
}
