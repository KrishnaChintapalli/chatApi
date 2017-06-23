package com.chat.service;

import com.chat.model.Conversation;
import com.chat.model.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
public interface IMessageService {

     void createMessage(Message m, String fromId, String toId);

     Map<Conversation,List<Message>> ListOfMessages(String id);

     List<Message> getConversation(String sender, String reciver);

}
