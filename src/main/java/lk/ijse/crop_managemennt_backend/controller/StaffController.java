package lk.ijse.crop_managemennt_backend.controller;


import lk.ijse.crop_managemennt_backend.customObj.StaffResponse;
import lk.ijse.crop_managemennt_backend.dto.StaffDTO;
import lk.ijse.crop_managemennt_backend.exception.DataPersistFailedException;
import lk.ijse.crop_managemennt_backend.exception.StaffNotFound;
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
@CrossOrigin("*")

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
    @GetMapping(value = "/{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffResponse getSelectedStaff(@PathVariable("staffId") String staffId){
        return staffService.getSelectedStaff(staffId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaff(@PathVariable("staffId") String staffId, @RequestBody StaffDTO staff){
        try{
            if (staff == null && (staffId == null || staff.equals(""))){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            staffService.updateStaff(staffId,staff);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (StaffNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{staffId}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("staffId") String staffId){
        try{
            staffService.deleteStaff(staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (StaffNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
