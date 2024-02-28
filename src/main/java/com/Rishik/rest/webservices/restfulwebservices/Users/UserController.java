package com.Rishik.rest.webservices.restfulwebservices.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers()
    {
        return userDaoService.getAllUsers();
    }
    @GetMapping(path="/users/{id}")
    public User retrieveSpecificUser(@PathVariable Integer id)
    {
        return userDaoService.getUser(id);
    }
    @PostMapping(path = "/users")
    public String addUser(@RequestBody User user)
    {
         userDaoService.addUser(user);
         return "New user, added";
    }
}
