package com.chat.controller;

import com.chat.model.Conversation;
import com.chat.model.Message;
import com.chat.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger("MessageController.class");

    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/message/{toid}", method = RequestMethod.POST)
    public void saveMessage(@PathVariable String id,  @PathVariable String toid, @RequestBody Message msg){

        messageService.createMessage(msg,id,toid);
    }

    @RequestMapping(value = "/messages",method = RequestMethod.GET)
    public @ResponseBody Map<Conversation,List<Message>> getMessages(@PathVariable String id){

        logger.info(id);
        return messageService.ListOfMessages(id);
    }
    @RequestMapping(value = "/message/{toid}", method = RequestMethod.GET)
    public @ResponseBody List<Message> getconversation(@PathVariable String id,  @PathVariable String toId){

        return null;
    }
}
