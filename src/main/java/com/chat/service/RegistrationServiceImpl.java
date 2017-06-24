package com.chat.service;

import com.chat.dao.IRegistrationRepository;
import com.chat.dao.IRoleRepository;
import com.chat.dao.IUserRepository;
import com.chat.model.Login;
import com.chat.model.Role;
import com.chat.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */
@Service
@Transactional
public class RegistrationServiceImpl implements IRegistrationService {

    public Logger logger = LoggerFactory.getLogger("RegistrationServiceImpl.class");

    @Autowired
    private IRegistrationRepository registrationRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IUserRepository userRepository;


    @Override
    public Login save(Login l) {
        logger.info("save Login Started" +l.toString());
        l.setCreated(new Date());
        l.setUpdated(new Date());
        Role role = roleRepository.findByName("USER");
        logger.info(role.getId().toString());
        l.setRoles(role);
        Login login =registrationRepository.save(l);
        User user = new User();
        user.setF_name(l.getF_name());
        user.setLogin(login);
        user.setL_name(l.getL_name());
        user.setCreated(new Date());
        user.setUpdaetd(new Date());
        logger.info(user.toString());
        userRepository.save(user);

        return login;
    }

    @Override
    public boolean isUserExist(String user) {
        if(user.contains("@")){
            return registrationRepository.existsByEmail(user);
        }
        return registrationRepository.existsByUserName(user);
    }

    @Override
    public boolean deactivateUser(String id) {
        Login login = registrationRepository.deleteById(Long.parseLong(id));
        return login.isActive();
    }

    @Override
    public Login getUser(String userName) {
        Login login ;
        if(userName.contains("@")) login = registrationRepository.findOneByEmail(userName);

       else login = registrationRepository.findOneByUserName(userName);

       return login;
    }


}
