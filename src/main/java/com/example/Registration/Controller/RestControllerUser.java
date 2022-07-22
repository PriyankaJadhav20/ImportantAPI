package com.example.Registration.Controller;

import com.example.Registration.Model.User;
import com.example.Registration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerUser {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/register")
    public String register( @RequestBody User user) {

        List<User> users = userRepository.findAll();
        System.out.println("New User -> " + user);

        for (User u: users) {
            if (user.equals(u)) {
                System.out.println("User already exists!");
                return "USER_ALREADY_EXISTS";
            }
        }

        userRepository.save(user);
        return "SUCCESS";

    }

    @PostMapping("/api/login")
    public String login( @RequestBody User user) {

        List<User> users = userRepository.findAll();

        for (User u: users) {
            if (u.equals(user)) {
                return user.getUserName();
            }
        }

        return "FAILURE";

    }

}
