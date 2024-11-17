package lk.ijse.crop_managemennt_backend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    private static int staffCounter = 0;
    private static int cropCounter = 0;
    private static int fieldCounter = 0;

    public static String createVehicleCode(){return "Vehicle-"+ UUID.randomUUID();}
    public static String createEquipmentId(){return "Equipment-"+ UUID.randomUUID();}
    public static synchronized String createStaffId(){
        staffCounter++;
        return String.format("S%04d", staffCounter);
    }
    public static synchronized String  createCropId(){
        cropCounter++;
        return String.format("C%04d",cropCounter);
    }
    public static String toBase64CropImage(MultipartFile cropImage) throws IOException {
        if (cropImage == null || cropImage.isEmpty()) {
            return null;
        }
        return Base64.getEncoder().encodeToString(cropImage.getBytes());
    }


    public static synchronized String createFieldId(){
        fieldCounter++;
        return String.format("F%04d",fieldCounter);
    }
    public static String toBase64FieldImage1(MultipartFile fieldImage1) throws IOException{
        if (fieldImage1 == null || fieldImage1.isEmpty()){
            return null;
        }
        return Base64.getEncoder().encodeToString(fieldImage1.getBytes());
    }

    public static String toBase64FieldImage2(MultipartFile fieldImage2) throws IOException{
        if (fieldImage2 == null || fieldImage2.isEmpty()){
            return null;
        }
        return Base64.getEncoder().encodeToString(fieldImage2.getBytes());
    }

}
