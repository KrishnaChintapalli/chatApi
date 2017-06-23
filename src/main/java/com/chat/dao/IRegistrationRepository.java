package com.chat.dao;

import com.chat.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */

@Repository
public interface IRegistrationRepository extends CrudRepository<Login, Long> {

    Login findOneByUserName(String username);

    Login findOneByEmail(String email);

    Login deleteByEmail(String email);

    Login deleteByUserName(String userName);

    boolean existsByUserName(String UserName);

    boolean existsByEmail(String email);


}
