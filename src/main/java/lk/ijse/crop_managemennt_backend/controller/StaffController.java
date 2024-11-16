package lk.ijse.crop_managemennt_backend.controller;


import lk.ijse.crop_managemennt_backend.dto.StaffDTO;
import lk.ijse.crop_managemennt_backend.exception.DataPersistFailedException;
import lk.ijse.crop_managemennt_backend.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor

public class StaffController {
    @Autowired
    private final StaffService staffService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDTO staff){
        if (staff == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try{
                staffService.saveStaff(staff);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDTO> getAllStaffs(){
        return staffService.getAllStaffs();
    }
}
