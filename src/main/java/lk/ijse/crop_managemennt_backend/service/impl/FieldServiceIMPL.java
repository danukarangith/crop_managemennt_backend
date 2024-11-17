package lk.ijse.crop_managemennt_backend.service.impl;

import lk.ijse.crop_managemennt_backend.dao.FieldDao;
import lk.ijse.crop_managemennt_backend.dao.StaffDao;
import lk.ijse.crop_managemennt_backend.dto.FieldDTO;
import lk.ijse.crop_managemennt_backend.entity.FieldEntity;
import lk.ijse.crop_managemennt_backend.entity.StaffEntity;
import lk.ijse.crop_managemennt_backend.service.FieldService;
import lk.ijse.crop_managemennt_backend.util.AppUtil;
import lk.ijse.crop_managemennt_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class FieldServiceIMPL implements FieldService {
    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private Mapping mapping;

    @Override
    @Transactional
    public void saveField(FieldDTO fieldDTO) {
        FieldEntity fieldEntity = mapping.convertToFieldEntity(fieldDTO);

        if (fieldEntity.getFieldCode() == null || fieldEntity.getFieldCode().isEmpty()){
            fieldEntity.setFieldCode(AppUtil.createFieldId());
        }

        List<StaffEntity> staff = getStaffFromIds(fieldDTO.getStaffIds());
        fieldEntity.setStaff(staff);

        fieldDao.save(fieldEntity);
    }
    private List<StaffEntity> getStaffFromIds(List<String> staffIds){
        return staffDao.findAllById(staffIds);
    }
    @Override
    public List<FieldDTO> getAllFields() {
        List<FieldEntity> getAllFields = fieldDao.findAll();
        return mapping.convertFieldToDTOList(getAllFields);
    }

}
