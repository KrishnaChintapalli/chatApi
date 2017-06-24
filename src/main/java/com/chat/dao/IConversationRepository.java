package com.chat.dao;

import com.chat.model.Conversation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@Repository
public interface IConversationRepository extends CrudRepository<Conversation, Long> {

    @Query(value = "select c from  Conversation c where  (c.user1_id=?1 and c.user2_id=?2) or (c.user1_id=?2 and c.user2_id=?1)")
    Conversation findConversation(long fromId, long toId);

    @Query(value = "select c from  Conversation c where  c.user1_id=?1 or c.user2_id=?1")
    List<Conversation> findConversationList(long id);
}
