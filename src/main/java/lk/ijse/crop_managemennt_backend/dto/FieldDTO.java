package lk.ijse.crop_managemennt_backend.dto;

import lk.ijse.crop_managemennt_backend.customObj.FieldResponse;
import lombok.*;
import org.springframework.data.geo.Point;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FieldDTO implements SuperDTO, FieldResponse {
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private double extendSize;
    private List<CropDTO> crops;
    private List<StaffDTO> staff;
    private String fieldImage1;
    private String fieldImage2;
    private List<String> staffIds;
}
