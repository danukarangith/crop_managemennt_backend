package lk.ijse.crop_managemennt_backend.customObj.impl;

import lk.ijse.crop_managemennt_backend.customObj.FieldResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class FieldErrorResponse implements Serializable , FieldResponse {
    private int errorCode;
    private String errorMessage;
}
