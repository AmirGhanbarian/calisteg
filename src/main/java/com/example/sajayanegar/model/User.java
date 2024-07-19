package com.example.sajayanegar.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @JsonIgnore
    private String id;
    @Indexed(unique = true)
    private String username;
    private String firstName;
    private String lastName;

}
