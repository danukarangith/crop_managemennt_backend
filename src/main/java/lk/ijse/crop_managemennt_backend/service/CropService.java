package lk.ijse.crop_managemennt_backend.service;

import lk.ijse.crop_managemennt_backend.customObj.CropResponse;
import lk.ijse.crop_managemennt_backend.dto.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrops();
    CropResponse getSelectedCrop(String cropCode);
    void updateCrop(CropDTO updateCropDTO);
    void deleteCrop(String cropCode);
}
