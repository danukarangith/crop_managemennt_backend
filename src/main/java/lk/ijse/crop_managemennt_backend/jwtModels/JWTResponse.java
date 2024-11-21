package lk.ijse.crop_managemennt_backend.jwtModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class JWTResponse {
    private String token;
}
