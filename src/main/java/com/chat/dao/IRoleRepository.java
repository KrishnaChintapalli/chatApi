package com.chat.dao;

import com.chat.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/21/17.
 */
@Repository
public interface IRoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String role);
}
