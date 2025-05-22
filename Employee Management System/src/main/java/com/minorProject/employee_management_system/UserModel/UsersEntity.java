package com.minorProject.employee_management_system.UserModel;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class UsersEntity {

    @Id
    private String email;

    private String username;
    private String password;

}
