package lk.ijse.crop_managemennt_backend.dao;

import lk.ijse.crop_managemennt_backend.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<VehicleEntity,String> {
}
