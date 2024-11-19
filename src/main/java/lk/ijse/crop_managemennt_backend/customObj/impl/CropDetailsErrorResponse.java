package lk.ijse.crop_managemennt_backend.customObj.impl;

import lk.ijse.crop_managemennt_backend.customObj.CropDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CropDetailsErrorResponse implements  CropDetailsResponse , Serializable {
    private int errorCode;
    private String errorMessage;
}
