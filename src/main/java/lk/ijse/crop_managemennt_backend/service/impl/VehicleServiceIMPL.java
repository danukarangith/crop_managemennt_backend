package lk.ijse.crop_managemennt_backend.service.impl;

import lk.ijse.crop_managemennt_backend.customObj.VehicleResponse;
import lk.ijse.crop_managemennt_backend.customObj.impl.VehicleErrorResponse;
import lk.ijse.crop_managemennt_backend.dao.VehicleDao;
import lk.ijse.crop_managemennt_backend.dto.VehicleDTO;
import lk.ijse.crop_managemennt_backend.entity.VehicleEntity;
import lk.ijse.crop_managemennt_backend.exception.DataPersistFailedException;
import lk.ijse.crop_managemennt_backend.service.VehicleService;
import lk.ijse.crop_managemennt_backend.util.AppUtil;
import lk.ijse.crop_managemennt_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceIMPL implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
   private Mapping mapping;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        System.out.println("1");
        vehicleDTO.setVehicleCode(AppUtil.createVehicleCode());
        System.out.println("2");
        var vehicleEntity = mapping.convertToVehicleEntity(vehicleDTO);
        System.out.println("3");
        var savedVehicle = vehicleDao.save(vehicleEntity);
        System.out.println("4");
        if (savedVehicle == null){
            System.out.println("5");
            throw new DataPersistFailedException("Cannot save vehicle");
        }
    }
    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<VehicleEntity> getAllVehicles = vehicleDao.findAll();
        return mapping.convertVehicleToDTOList(getAllVehicles);
    }

    @Override
    public VehicleResponse getSelectedVehicle(String vehicleCode) {
        if (vehicleDao.existsById(vehicleCode)){
            VehicleEntity vehicleEntityByVehicleCode = vehicleDao.getReferenceById(vehicleCode);
            return (VehicleResponse) mapping.convertToVehicleDTO(vehicleEntityByVehicleCode);
        }else {
            return new VehicleErrorResponse(0,"Vehicle not Found");
        }
    }
}
