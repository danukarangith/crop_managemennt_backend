package lk.ijse.crop_managemennt_backend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    private static int staffCounter = 0;

    public static String createVehicleCode(){return "Vehicle-"+ UUID.randomUUID();}
    public static String createEquipmentId(){return "Equipment-"+ UUID.randomUUID();}
    public static synchronized String createStaffId(){
        staffCounter++;
        return String.format("S%04d", staffCounter);
    }

}
