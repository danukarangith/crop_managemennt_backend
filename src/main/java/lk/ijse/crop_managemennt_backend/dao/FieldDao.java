package lk.ijse.crop_managemennt_backend.dao;

import lk.ijse.crop_managemennt_backend.entity.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FieldDao extends JpaRepository<FieldEntity,String> {
}
