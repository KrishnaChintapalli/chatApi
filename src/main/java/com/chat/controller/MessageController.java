package com.chat.controller;

import com.chat.model.Conversation;
import com.chat.model.Message;
import com.chat.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */
@RestController
@RequestMapping("/user/{id}")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/message/{id}", method = RequestMethod.POST)
    public void saveMessage(@PathVariable String fromId,  @PathVariable String toid, @RequestBody Message msg){

    }

    @RequestMapping(value = "/messages",method = RequestMethod.GET)
    public Map<Conversation,List<Message>> getMessages(@PathVariable String userId){

        return messageService.ListOfMessages(userId);
    }
    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public List<Message> getconversation(@PathVariable String fromId,  @PathVariable String toId){

        return null;
    }
}
