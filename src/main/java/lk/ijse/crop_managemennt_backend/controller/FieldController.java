package lk.ijse.crop_managemennt_backend.controller;

import lk.ijse.crop_managemennt_backend.customObj.FieldResponse;
import lk.ijse.crop_managemennt_backend.dto.FieldDTO;
import lk.ijse.crop_managemennt_backend.exception.FieldNotFound;
import lk.ijse.crop_managemennt_backend.service.FieldService;
import lk.ijse.crop_managemennt_backend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/field")
@RequiredArgsConstructor

public class FieldController {
    @Autowired
    private final FieldService fieldService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldName") String fieldName,
            @RequestPart("latitude") String latitude,
            @RequestPart("longitude") String longitude,
            @RequestPart("extentSize") String extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2,
            @RequestPart("staffIds") String staffIds
    ){
        try{
            List<String> staffIdList = Arrays.asList(staffIds.split(","));
            Point fieldLocation = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude));
            String base64FieldImage1 = AppUtil.toBase64FieldImage1(fieldImage1);
            String base64FieldImage2 = AppUtil.toBase64FieldImage2(fieldImage2);
            var fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(AppUtil.createFieldId());
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setFieldLocation(fieldLocation);
            fieldDTO.setExtendSize(Double.parseDouble(extentSize));
            fieldDTO.setFieldImage1(base64FieldImage1);
            fieldDTO.setFieldImage2(base64FieldImage2);
            fieldDTO.setStaffIds(staffIdList);

            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (FieldNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllFields(){
        return fieldService.getAllFields();
    }
    @GetMapping(value = "/{fieldCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldResponse getSelectedField(@PathVariable("fieldCode") String fieldCode){
        return fieldService.getSelectedField(fieldCode);
    }
    @PatchMapping(value = "/{fieldCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateField(
            @PathVariable("fieldCode") String fieldCode,
            @RequestPart("fieldName") String fieldName,
            @RequestPart("latitude") String latitude,
            @RequestPart("longitude") String longitude,
            @RequestPart("extentSize") String extentSize,
            @RequestPart("fieldImage1") MultipartFile fieldImage1,
            @RequestPart("fieldImage2") MultipartFile fieldImage2,
            @RequestPart("staffIds") String staffIds
    ) {
        try {
            // Split staffIds string into list
            List<String> staffIdList = Arrays.asList(staffIds.split(","));
            String updateBase64FieldImage1 = null;
            String updateBase64FieldImage2 = null;

            // Convert field images to Base64 if provided
            if (fieldImage1 != null && !fieldImage1.isEmpty()) {
                updateBase64FieldImage1 = AppUtil.toBase64FieldImage1(fieldImage1);
            }

            if (fieldImage2 != null && !fieldImage2.isEmpty()) {
                updateBase64FieldImage2 = AppUtil.toBase64FieldImage2(fieldImage2);
            }

            // Create and populate FieldDTO
            FieldDTO updateFieldDTO = new FieldDTO();
            updateFieldDTO.setFieldCode(fieldCode);
            updateFieldDTO.setFieldName(fieldName);
            updateFieldDTO.setFieldLocation(new Point(Double.parseDouble(latitude), Double.parseDouble(longitude)));
            updateFieldDTO.setExtendSize(Double.parseDouble(extentSize));
            updateFieldDTO.setStaffIds(staffIdList);

            if (updateBase64FieldImage1 != null) {
                updateFieldDTO.setFieldImage1(updateBase64FieldImage1);
            }

            if (updateBase64FieldImage2 != null) {
                updateFieldDTO.setFieldImage2(updateBase64FieldImage2);
            }

            // Call the service method to update the field
            fieldService.updateField(updateFieldDTO);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FieldNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{fieldCode}")
    public ResponseEntity<Void> deleteField(@PathVariable("fieldCode") String fieldCode){
        try{
            fieldService.deleteField(fieldCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (FieldNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
