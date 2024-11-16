package lk.ijse.crop_managemennt_backend.customObj.impl;

import lk.ijse.crop_managemennt_backend.customObj.CropResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CropErrorResponse implements Serializable , CropResponse {
    private int errorCode;
    private String errorMessage;
}
