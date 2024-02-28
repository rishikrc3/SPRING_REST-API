package com.Rishik.rest.webservices.restfulwebservices.Users;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,"Rishik Chakravarty" ,"14/02/2002")));


    public List<User> getAllUsers()
    {
        return users;
    }
}
