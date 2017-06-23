package com.chat.service;

import com.chat.model.Login;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */
public interface IRegistrationService {

    Login save(Login u);

    boolean isUserExist(String userName);

    boolean deactivateUser(String userName );

    Login getUser(String userName);


}
