package com.minorProject.employee_management_system.ServiceLayer;

import com.minorProject.employee_management_system.Repository.ServiceRepository;
import com.minorProject.employee_management_system.UserModel.UsersEntity;
import com.minorProject.employee_management_system.Users.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer implements ServiceUserInterface{


    @Autowired
    ServiceRepository serviceRepository;

    public String createSignUpPage(User user)
    {
        UsersEntity usersEntity = new UsersEntity();
        BeanUtils.copyProperties(user, usersEntity);
        serviceRepository.save(usersEntity);
        return "SuccessFull";
    }

    public List<User> readSignUp()
    {
        List<UsersEntity> usersEntityList = serviceRepository.findAll();
        List<User> users = new ArrayList<>();
        for(UsersEntity usersEntity :usersEntityList)
        {
            User user =new User();
            user.setEmail(usersEntity.getEmail());
            user.setUsername(usersEntity.getUsername());
            user.setPassword(usersEntity.getPassword());

            users.add(user);
        }
        return users;
    }


    public User readSignUp(String email)
    {
        UsersEntity usersEntity = serviceRepository.findById(email).get();
        User user =new User();
        BeanUtils.copyProperties(usersEntity, user);
        return user;
    }


    public boolean deleteSignUp(String email)
    {
        serviceRepository.deleteById(email);
        return true;
    }

    public String updateSignUp(User user, String email)
    {
        Optional<UsersEntity> usersEntity = serviceRepository.findById(email);
        if(usersEntity.isPresent())
        {
            UsersEntity existUser = usersEntity.get();
            existUser.setUsername(user.getUsername());
            existUser.setPassword(user.getPassword());


            serviceRepository.save(existUser);
            return "Update Sccessfull";
        }
        return "Not Found";
    }




}
