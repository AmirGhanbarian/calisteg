package com.example.sajayanegar.service;

import com.example.sajayanegar.model.User;
import com.example.sajayanegar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User save(User user) throws Exception {
        if (userIsValid(user)) {
            return userRepository.save(user);
        }
        throw new Exception();
    }


    //todo getById
//    public getByid(Long id){
        //return user
//}

    private boolean userIsValid(User user){
        if(user.getUsername()==null){
            return false;
        }
        return true;
    }

}
