package lk.ijse.crop_managemennt_backend.dao;

import lk.ijse.crop_managemennt_backend.entity.CropDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CropDetailsDao extends JpaRepository<CropDetailsEntity, String> {
}
