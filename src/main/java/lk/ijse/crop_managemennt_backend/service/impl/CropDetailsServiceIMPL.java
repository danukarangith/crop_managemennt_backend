package lk.ijse.crop_managemennt_backend.service.impl;

import lk.ijse.crop_managemennt_backend.dao.CropDao;
import lk.ijse.crop_managemennt_backend.dao.CropDetailsDao;
import lk.ijse.crop_managemennt_backend.dao.FieldDao;
import lk.ijse.crop_managemennt_backend.dao.StaffDao;
import lk.ijse.crop_managemennt_backend.dto.CropDetailsDTO;
import lk.ijse.crop_managemennt_backend.entity.CropDetailsEntity;
import lk.ijse.crop_managemennt_backend.entity.CropEntity;
import lk.ijse.crop_managemennt_backend.entity.FieldEntity;
import lk.ijse.crop_managemennt_backend.entity.StaffEntity;
import lk.ijse.crop_managemennt_backend.service.CropDetailsService;
import lk.ijse.crop_managemennt_backend.util.AppUtil;
import lk.ijse.crop_managemennt_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
