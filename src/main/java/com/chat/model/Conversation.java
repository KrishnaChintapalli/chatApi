package com.chat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by sivaramakrishnaprasadchintapalli on 6/22/17.
 */

//@NamedQueries(value = {
//        @NamedQuery(name = "findConversation",
@Entity
@Table(name = "conversation")

public class Conversation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long user1_id;

    private long user2_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conversation")
    private List<Message> messages ;

    public Conversation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser1_id() {
        return user1_id;
    }

    public void setUser1_id(long user1_id) {
        this.user1_id = user1_id;
    }

    public long getUser2_id() {
        return user2_id;
    }

    public void setUser2_id(long user2_id) {
        this.user2_id = user2_id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
