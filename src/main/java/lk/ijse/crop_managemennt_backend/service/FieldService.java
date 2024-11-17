package lk.ijse.crop_managemennt_backend.service;


import lk.ijse.crop_managemennt_backend.customObj.FieldResponse;
import lk.ijse.crop_managemennt_backend.dto.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    List<FieldDTO> getAllFields();
    FieldResponse getSelectedField(String fieldCode);
    void updateField(FieldDTO updateFieldDTO);
    void deleteField(String fieldCode);
}
