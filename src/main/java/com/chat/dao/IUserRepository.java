package com.chat.dao;

import com.chat.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {


}
