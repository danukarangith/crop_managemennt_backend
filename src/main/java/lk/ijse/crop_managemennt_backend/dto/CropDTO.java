package lk.ijse.crop_managemennt_backend.dto;

import lk.ijse.crop_managemennt_backend.customObj.CropResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CropDTO implements SuperDTO, CropResponse {
    private String cropCode;
    private String cropCommonName;
    private String cropScientificName;
    private String cropImage;
    private String category;
    private String cropSeason;
    private String fieldCode;
}
