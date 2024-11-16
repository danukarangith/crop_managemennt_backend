package lk.ijse.crop_managemennt_backend.dao;

import lk.ijse.crop_managemennt_backend.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StaffDao extends JpaRepository<StaffEntity,String> {
}