package com.chat.service;

import com.chat.dao.IUserRepository;
import com.chat.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@Service
public class UserSereviceImpl implements IUserservice {

    public Logger logger = LoggerFactory.getLogger("UserSereviceImpl.class");

    @Autowired
    IUserRepository userRepository;

    @Override
    public User getUser(String id) {
        logger.info("getUser info meethod started "+"userID" +id);
        long userId = Long.parseLong(id);
        User user = userRepository.findOne(userId);
        logger.info("User Info "+"userID" + user.toString());

        return user;
    }

    @Override
    public List<User> getUserList(String id) {
        logger.info("getUserlist starts: userId  :" + id);
        Long userId = Long.parseLong(id);
        List<User> users = (List<User>) userRepository.findAll();
        users.removeIf(user-> user.getId()==userId);
        logger.info("getUserList ended");
        return users;
    }

    @Override
    public User updateUser(User user) {
        logger.info("user update starts:"+user.toString());
        User user1 = userRepository.findOne(user.getId());
        user1.setF_name(user.getF_name());
        user1.setL_name(user.getL_name());
        user1.setAddress(user.getAddress());
        user1.setCity(user.getCity());
        user1.setState(user.getState());
        user1.setZipcode(user.getZipcode());
        user1.setDob(user.getDob());
        user1.setUpdaetd(new Date());
        user1 = userRepository.save(user1);
        logger.info("user updated success fully"+user1.toString());
        return user1;
    }
}
