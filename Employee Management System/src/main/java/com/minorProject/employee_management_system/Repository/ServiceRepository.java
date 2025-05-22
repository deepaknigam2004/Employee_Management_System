package com.minorProject.employee_management_system.Repository;

import com.minorProject.employee_management_system.UserModel.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<UsersEntity, String> {


}
