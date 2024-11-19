package lk.ijse.crop_managemennt_backend.service.impl;

import lk.ijse.crop_managemennt_backend.customObj.CropDetailsResponse;
import lk.ijse.crop_managemennt_backend.customObj.impl.CropDetailsErrorResponse;
import lk.ijse.crop_managemennt_backend.dao.CropDao;
import lk.ijse.crop_managemennt_backend.dao.CropDetailsDao;
import lk.ijse.crop_managemennt_backend.dao.FieldDao;
import lk.ijse.crop_managemennt_backend.dao.StaffDao;
import lk.ijse.crop_managemennt_backend.dto.CropDetailsDTO;
import lk.ijse.crop_managemennt_backend.entity.CropDetailsEntity;
import lk.ijse.crop_managemennt_backend.entity.CropEntity;
import lk.ijse.crop_managemennt_backend.entity.FieldEntity;
import lk.ijse.crop_managemennt_backend.entity.StaffEntity;
import lk.ijse.crop_managemennt_backend.exception.CropDetailsNotFound;
import lk.ijse.crop_managemennt_backend.service.CropDetailsService;
import lk.ijse.crop_managemennt_backend.util.AppUtil;
import lk.ijse.crop_managemennt_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CropDetailsServiceIMPL implements CropDetailsService {
    @Autowired
    private CropDetailsDao cropDetailsDao;

    @Autowired
    private CropDao cropDao;

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private Mapping mapping;

    @Override
    @Transactional
    public void saveCropDetails(CropDetailsDTO cropDetailsDTO) {
        CropDetailsEntity cropDetailsEntity = mapping.convertToCropDetailsEntity(cropDetailsDTO);

        if (cropDetailsEntity.getLogCode() == null || cropDetailsEntity.getLogCode().isEmpty()){
            cropDetailsEntity.setLogCode(AppUtil.createLogCode());
        }

        List<FieldEntity> fields = getFieldsFromCodes(cropDetailsDTO.getFieldCodes());
        List<CropEntity> crops = getCropsFromCodes(cropDetailsDTO.getCropCodes());
        List<StaffEntity> staff = getStaffFromIds(cropDetailsDTO.getStaffIds());

        cropDetailsEntity.setField(fields);
        cropDetailsEntity.setCrop(crops);
        cropDetailsEntity.setStaff(staff);

        cropDetailsDao.save(cropDetailsEntity);
    }

    @Override
    public List<CropDetailsDTO> getAllCropDetails() {
        List<CropDetailsEntity> getAllCropDetails = cropDetailsDao.findAll();
        return mapping.convertCropDetailsToDTOList(getAllCropDetails);
    }

    @Override
    public CropDetailsResponse getSelectedCropDetail(String logCode) {
        if (cropDetailsDao.existsById(logCode)) {
            CropDetailsEntity cropDetailsEntityByLogCode = cropDetailsDao.getReferenceById(logCode);
            return mapping.convertToCropDetailsDTO(cropDetailsEntityByLogCode);
        } else {
            return new CropDetailsErrorResponse(0, "Crop Details not Found");
        }
    }
    @Override
    public void updateCropDetails(CropDetailsDTO updatecropDetailsDTO) {
        Optional<CropDetailsEntity> existingEntityOptional = cropDetailsDao.findById(updatecropDetailsDTO.getLogCode());

        if (existingEntityOptional.isPresent()) {
            CropDetailsEntity existingEntity = existingEntityOptional.get();

            existingEntity.setLogDetails(updatecropDetailsDTO.getLogDetails());
            existingEntity.setObservedImage(updatecropDetailsDTO.getObservedImage());


            if (updatecropDetailsDTO.getFieldCodes() != null) {
                List<FieldEntity> fieldEntities = fieldDao.findAllById(updatecropDetailsDTO.getFieldCodes());
                existingEntity.setField(fieldEntities);
            }

            if (updatecropDetailsDTO.getCropCodes() != null) {
                List<CropEntity> cropEntities = cropDao.findAllById(updatecropDetailsDTO.getCropCodes());
                existingEntity.setCrop(cropEntities);
            }

            if (updatecropDetailsDTO.getStaffIds() != null) {
                List<StaffEntity> staffEntities = staffDao.findAllById(updatecropDetailsDTO.getStaffIds());
                existingEntity.setStaff(staffEntities);
            }

            cropDetailsDao.save(existingEntity);
        } else {
            throw new CropDetailsNotFound("Crop details with logCode " + updatecropDetailsDTO.getLogCode() + " not found");
        }
    }
    private List<FieldEntity> getFieldsFromCodes(List<String> fieldCodes){
        return fieldDao.findAllById(fieldCodes);
    }

    private List<CropEntity> getCropsFromCodes(List<String> cropCodes){
        return cropDao.findAllById(cropCodes);
    }

    private List<StaffEntity> getStaffFromIds(List<String> staffIds){
        return staffDao.findAllById(staffIds);
    }


}
