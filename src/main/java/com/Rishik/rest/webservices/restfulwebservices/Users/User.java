package com.Rishik.rest.webservices.restfulwebservices.Users;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;




@Entity(name="user_details")

public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Name is requiresd")
    private String name;
    private String birthDate;

    public User(Integer id, String name, String birthDate)
    {
        this.id = id;
        this.name = name;
        this.birthDate= birthDate;
    }

    public Integer getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getBirthDate()
    {
        return birthDate;
    }


    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate= birthDate;
    }

}
