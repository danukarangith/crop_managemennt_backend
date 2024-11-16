package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    List<StaffDTO> getAllStaffs();
}
