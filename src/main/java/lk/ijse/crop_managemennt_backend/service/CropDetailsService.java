package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.dto.CropDetailsDTO;

import java.util.List;

public interface CropDetailsService {
    void saveCropDetails(CropDetailsDTO cropDetailsDTO);
    List<CropDetailsDTO> getAllCropDetails();
}
