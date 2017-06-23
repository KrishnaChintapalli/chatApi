package com.chat.controller;

import com.chat.model.User;
import com.chat.service.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserDetailController {

    @Autowired
    IUserservice userservice;

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public User profile(@PathVariable String id){

        User user = userservice.getUser(id);
        return user;
    }

    @RequestMapping(value = "/userList/{id}", method = RequestMethod.GET)
    public List<User> userList(@PathVariable String id){

       List<User> userList = userservice.getUserList(id);
        return userList;
    }
}
