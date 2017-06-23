package com.chat.service;

import com.chat.dao.IRegistrationRepository;
import com.chat.dao.IRoleRepository;
import com.chat.model.Login;
import com.chat.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */
@Service
@Transactional
public class RegistrationService implements IRegistrationService {

    @Autowired
    private IRegistrationRepository registrationRepository;
    @Autowired
    private IRoleRepository roleRepository;


    @Override
    public Login save(Login u) {
        u.setCreated(new Date());
        u.setUpdated(new Date());
        Role role = roleRepository.findByName("USER");
        u.setRoles(role);
        return registrationRepository.save(u);
    }

    @Override
    public boolean isUserExist(String user) {
        if(user.contains("@")){
            return registrationRepository.existsByEmail(user);
        }
        return registrationRepository.existsByUserName(user);
    }

    @Override
    public boolean deactivateUser(String userName) {
        boolean status;
        if(userName.contains("@")){
            Login login = registrationRepository.deleteByEmail(userName);

        }else{
            Login login = registrationRepository.deleteByUserName(userName);

        }
        return true;
    }
}
