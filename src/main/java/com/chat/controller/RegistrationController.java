package com.chat.controller;

import com.chat.model.Login;
import com.chat.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */
@RestController
@RequestMapping(value = "/user")
public class RegistrationController {
    public static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@Validated @RequestBody Login login, HttpServletResponse response){
        logger.info("Register method started and request body"+login.toString());
      HashMap<String,String > resp = new HashMap<>();

     Login login1 = registrationService.save(login);
      if(login1!=null){
          response.setHeader(HttpStatus.CREATED.toString(),"");
          resp.put("userName",login1.getUserName());
          resp.put("userId",  Long.toString(login1.getId()));
//          resp.put("token",)
          logger.info("User created Successfuly"+login1.toString());
          return login1.toString();
      }
      else {
          logger.error("user creation failed" +login.toString());
          return login1.toString();
      }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Validated @RequestBody Login login){
        logger.info("User Login starts"+login);


        return "";
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping
    public String hello(){
        return "Hello World!!!";
    }
}
