package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.customObj.StaffResponse;
import lk.ijse.crop_managemennt_backend.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    List<StaffDTO> getAllStaffs();
    StaffResponse getSelectedStaff(String staffId);
    void updateStaff(String staffId, StaffDTO staffDTO);
    void deleteStaff(String staffId);
}
