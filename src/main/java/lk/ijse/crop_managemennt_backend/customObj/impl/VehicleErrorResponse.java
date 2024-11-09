package lk.ijse.crop_managemennt_backend.customObj.impl;

import lk.ijse.crop_managemennt_backend.customObj.VehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleErrorResponse  implements Serializable, VehicleResponse {
    private int errorCode;
    private String errorMessage;
}
