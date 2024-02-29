package com.Rishik.rest.webservices.restfulwebservices.Users;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers()
    {

        //return userDaoService.getAllUsers();
        List<User>users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);

        return users;
    }
    @GetMapping(path="/users/{id}")
    public User retrieveSpecificUser(@PathVariable Integer id)
    {
        User user= userDaoService.getUser(id);
        if(user==null)
        {
            throw new UserNotFoundException("User not found for id:"+id);

        }
        return user;
    }
    @PostMapping(path = "/users")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation Errors "+bindingResult.getAllErrors());
        }
         userDaoService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("New user added successfully");
    }

    @DeleteMapping(path="users/{id}")
    public String deleteUser(@PathVariable Integer id, @RequestBody User user)
    {
        userDaoService.deleteUser(id,user);
        return "User, deleted";
    }
}
