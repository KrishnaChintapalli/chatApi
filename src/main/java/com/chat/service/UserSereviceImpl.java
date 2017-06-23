package com.chat.service;

import com.chat.dao.IUserRepository;
import com.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@Service
public class UserSereviceImpl implements IUserservice {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User getUser(String id) {
        long userId = Long.parseLong(id);
        User user = userRepository.findOne(userId);
        return user;
    }

    @Override
    public List<User> getUserList(String id) {
        Long userId = Long.parseLong(id);
        List<User> users = (List<User>) userRepository.findAll();
        users.removeIf(user-> user.getId()==userId);
        return users;
    }
}
