package lk.ijse.crop_managemennt_backend.customObj.impl;

import lk.ijse.crop_managemennt_backend.customObj.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserErrorResponse implements Serializable ,UserResponse {
    private int errorCode;
    private String errorMessage;
}
