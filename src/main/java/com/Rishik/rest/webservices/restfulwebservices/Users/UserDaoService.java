package com.Rishik.rest.webservices.restfulwebservices.Users;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDaoService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,"Rishik Chakravarty" ,"14/02/2002"),
            new User(2, "Lojens Chakravarty", "15/12/2020"),
            new User(3, "Gregory House", "11/07/1959")));


    public List<User> getAllUsers()
    {
        return users;
    }

    public User getUser(Integer id)
    {
        return users.stream()
                .filter(user->user.getId().equals(id))
                .findFirst().orElse(null);
    }
}
