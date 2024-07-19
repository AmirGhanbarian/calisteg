package com.example.sajayanegar.controller;

import com.example.sajayanegar.model.User;
import com.example.sajayanegar.repository.UserRepository;
import com.example.sajayanegar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;




    //todo implement getAll



    //todo implement getById
//    @GetMapping()
//    public List<User> returnAllUser(){
//      //  return userRepository.findAll();
//    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try{
            userService.save(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
    }
}
