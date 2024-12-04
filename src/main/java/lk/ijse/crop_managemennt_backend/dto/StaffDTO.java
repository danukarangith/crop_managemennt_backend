package lk.ijse.crop_managemennt_backend.dto;

import jakarta.validation.constraints.*;
import lk.ijse.crop_managemennt_backend.customObj.StaffResponse;
import lk.ijse.crop_managemennt_backend.enums.Designation;
import lk.ijse.crop_managemennt_backend.enums.Gender;
import lk.ijse.crop_managemennt_backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data


public class StaffDTO implements SuperDTO, StaffResponse {
    @NotBlank(message = "Staff ID cannot be blank")
    private String staffId;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Designation cannot be null")
    private Designation designation;

    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @NotNull(message = "Joined date cannot be null")
    private LocalDate joinedDate;

    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @NotBlank(message = "Address Line 1 cannot be blank")
    private String addressLine1;

    @NotBlank(message = "Address Line 2 cannot be blank")
    private String addressLine2;

    private String addressLine3;
    private String addressLine4;
    private String addressLine5;

    @NotBlank(message = "Contact number cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be exactly 10 digits")
    private String contactNo;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Role cannot be null")
    private Role role;
}
