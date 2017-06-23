package com.chat.service;

import com.chat.model.User;

import java.util.List;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
public interface IUserservice {

    User getUser(String id);

    List<User> getUserList(String id);
}
