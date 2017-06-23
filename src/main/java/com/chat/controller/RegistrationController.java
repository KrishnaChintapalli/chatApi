package com.chat.controller;

import com.chat.model.Login;
import com.chat.service.RegistrationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */
@RestController
@RequestMapping(value = "/account")
public class RegistrationController {
    public static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    @Autowired
    private RegistrationServiceImpl registrationService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@Validated @RequestBody Login login, HttpServletResponse response){
        logger.info("Register method started and request body"+login.toString());
      HashMap<String,String > resp = new HashMap<>();

     Login login1 = registrationService.save(login);
      if(login1!=null){
          resp.put("userName",login1.getUserName());
          resp.put("userId",  Long.toString(login1.getId()));
          resp.put("token","");
          logger.info("User created Successfuly"+login1.toString());
          return resp.toString();
      }
      else {
          logger.error("user creation failed" +login.toString());
          return resp.toString();
      }

    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@Validated @RequestBody Login login){
//        logger.info("User Login starts"+login);
//registrationService.getUser(login);
//
//        return "";
//    }
    @RequestMapping(value = "/deactivate/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        boolean status = registrationService.deactivateUser(id);
    }
}
