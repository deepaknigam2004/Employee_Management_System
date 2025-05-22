package com.minorProject.employee_management_system.ServiceLayer;
import com.minorProject.employee_management_system.Users.User;

import java.util.List;

public interface ServiceUserInterface {

    String createSignUpPage(User user);
    List<User> readSignUp();
    boolean deleteSignUp(String email);
    String updateSignUp(User user, String email);
    User readSignUp(String email);
}
