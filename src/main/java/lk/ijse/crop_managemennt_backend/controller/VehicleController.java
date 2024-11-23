package lk.ijse.crop_managemennt_backend.controller;


import lk.ijse.crop_managemennt_backend.customObj.VehicleResponse;
import lk.ijse.crop_managemennt_backend.dto.VehicleDTO;
import lk.ijse.crop_managemennt_backend.exception.DataPersistFailedException;
import lk.ijse.crop_managemennt_backend.exception.VehicleNotFound;
import lk.ijse.crop_managemennt_backend.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVehicle(@RequestBody VehicleDTO vehicle){
        if (vehicle == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                vehicleService.saveVehicle(vehicle);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDTO> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping(value = "/{vehicleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleResponse getSelectedVehicle(@PathVariable("vehicleCode") String vehicleCode){
        return vehicleService.getSelectedVehicle(vehicleCode);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{vehicleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateVehicle(@PathVariable("vehicleCode") String vehicleCode, @RequestBody VehicleDTO vehicle){
        try{
            if (vehicle == null && (vehicleCode == null || vehicle.equals(""))){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            vehicleService.updateVehicle(vehicleCode,vehicle);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (VehicleNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{vehicleCode}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("vehicleCode") String vehicleCode){
        try{
            vehicleService.deleteVehicle(vehicleCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (VehicleNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
