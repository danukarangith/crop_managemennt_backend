package lk.ijse.crop_managemennt_backend.service.impl;

import lk.ijse.crop_managemennt_backend.customObj.StaffResponse;
import lk.ijse.crop_managemennt_backend.customObj.impl.StaffErrorResponse;
import lk.ijse.crop_managemennt_backend.dao.StaffDao;
import lk.ijse.crop_managemennt_backend.dto.StaffDTO;
import lk.ijse.crop_managemennt_backend.entity.StaffEntity;
import lk.ijse.crop_managemennt_backend.exception.DataPersistFailedException;
import lk.ijse.crop_managemennt_backend.exception.StaffNotFound;
import lk.ijse.crop_managemennt_backend.service.StaffService;
import lk.ijse.crop_managemennt_backend.util.AppUtil;
import lk.ijse.crop_managemennt_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StaffServiceIMPL implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
        staffDTO.setStaffId(AppUtil.createStaffId());
        var staffEntity = mapping.convertToStaffEntity(staffDTO);
        var savedStaff = staffDao.save(staffEntity);
        if (savedStaff == null){
            throw new DataPersistFailedException("Cannot save Staff");
        }
    }
    @Override
    public List<StaffDTO> getAllStaffs() {
        List<StaffEntity> getAllStaffs = staffDao.findAll();
        return mapping.convertStaffToDTOList(getAllStaffs);
    }
    @Override
    public StaffResponse getSelectedStaff(String staffId) {
        if (staffDao.existsById(staffId)) {
            StaffEntity staffEntityByStaffId = staffDao.getReferenceById(staffId);
            return mapping.convertToStaffDTO(staffEntityByStaffId);
        } else {
            return new StaffErrorResponse(0, "Staff not Found");
        }
    }
    @Override
    public void updateStaff(String staffId, StaffDTO incomestaffDTO) {
        Optional<StaffEntity> tmpStaffEntity = staffDao.findById(staffId);

        if (!tmpStaffEntity.isPresent()) {
            throw new StaffNotFound("Staff not found");
        } else {
            StaffEntity staffEntity = tmpStaffEntity.get();

            staffEntity.setFirstName(incomestaffDTO.getFirstName());
            staffEntity.setLastName(incomestaffDTO.getLastName());
            staffEntity.setDesignation(incomestaffDTO.getDesignation());
            staffEntity.setGender(incomestaffDTO.getGender());
            staffEntity.setJoinedDate(incomestaffDTO.getJoinedDate());
            staffEntity.setDob(incomestaffDTO.getDob());
            staffEntity.setAddressLine1(incomestaffDTO.getAddressLine1());
            staffEntity.setAddressLine2(incomestaffDTO.getAddressLine2());
            staffEntity.setAddressLine3(incomestaffDTO.getAddressLine3());
            staffEntity.setAddressLine4(incomestaffDTO.getAddressLine4());
            staffEntity.setAddressLine5(incomestaffDTO.getAddressLine5());
            staffEntity.setContactNo(incomestaffDTO.getContactNo());
            staffEntity.setEmail(incomestaffDTO.getEmail());
            staffEntity.setRole(incomestaffDTO.getRole());

            staffDao.save(staffEntity);
        }
    }
    @Override
    public void deleteStaff(String staffId) {
        Optional<StaffEntity> findId = staffDao.findById(staffId);
        if (!findId.isPresent()){
            throw new StaffNotFound("Staff not Found");
        }else {
            staffDao.deleteById(staffId);
        }
    }


}
