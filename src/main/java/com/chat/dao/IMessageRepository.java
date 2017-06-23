package com.chat.dao;

import com.chat.model.Conversation;
import com.chat.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@Repository
public interface IMessageRepository extends CrudRepository<Message, Long>{

    List<Message> findByConversationId(Conversation conversation);
}
