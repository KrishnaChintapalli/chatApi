package com.chat.controller;

import com.chat.model.User;
import com.chat.service.IUserservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserDetailController {

    Logger logger = LoggerFactory.getLogger("UserDetailController.class");

    @Autowired
    IUserservice userservice;

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public User profile(@PathVariable String id){
        logger.info("get profile method Started" + id);
        User user = userservice.getUser(id);
        logger.info(user.toString());
        return user;
    }

    @RequestMapping(value = "/userList/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> userList(@PathVariable String id){
        logger.info("UserList Details stats");
       List<User> userList = userservice.getUserList(id);
       logger.info("userList details ends");
        return userList;
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User updateUser(@PathVariable String id,@RequestBody User user){
        logger.info("updateUser method starts");
        user.setId(Long.parseLong(id));
        user = userservice.updateUser(user);
        logger.info("Update user ends" + user.toString());
        return user;
    }

}
