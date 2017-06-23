package com.chat.service;

import com.chat.dao.IConversationRepository;
import com.chat.dao.IMessageRepository;
import com.chat.model.Conversation;
import com.chat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageRepository messageRepository;

    @Autowired
    IConversationRepository conversationRepository;


    @Override
    public void createMessage(Message msg, String fromId, String toId) {

        long sender = Long.parseLong(fromId);
        long reciver = Long.parseLong(toId);
        Conversation conversation = conversationRepository.findConversation(sender,reciver);
        msg.setConversation(conversation);
        msg.setCreatedOn(new Date());
        msg.setFrom_id(sender);
        msg.setTo_id(reciver);
        messageRepository.save(msg);
    }

    @Override
    public Map<Conversation,List<Message>> ListOfMessages(String id) {
        long sender = Long.parseLong(id);
        List<Conversation> conversationList = conversationRepository.findConversationList(sender);
        HashMap<Conversation, List<Message>> messages = new HashMap<>();
        for(Conversation conversation:conversationList){
            List<Message> messageList = messageRepository.findByConversationId(conversation);
            messages.put(conversation,messageList);
        }
        return messages;
    }

    @Override
    public List<Message> getConversation(String from, String to) {
       long sender =Long.parseLong(from);
       long reciver = Long.parseLong(to);
        Conversation conversation = conversationRepository.findConversation(sender,reciver);
        return messageRepository.findByConversationId(conversation);
//        return null;
    }


}
