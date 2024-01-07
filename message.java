/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnet;

import java.util.Date;

/**
 *
 * @author EnisBugra
 */
public class message {
    private String messageContent;
    private Date time;
    private boolean seen;
    private boolean isFriend;
    private users sender;
    private users receiver;
    
    
    public message(String messageContent,users sender,users receiver){
        this.messageContent = messageContent;
        this.sender = sender;
        this.receiver = receiver;
        this.time = new Date();
        this.seen = false;     
        this.isFriend = false;
    }
    
    public users getReceiver(){
        return this.receiver;
    }
    
    public boolean sendMessage(){
        return this.receiver.receiveMessage(this);
    }
    
    public void setSeen(){
        this.seen = true;
    }
    
    public void setIsFriend(){
        this.isFriend = true;
    }
    
    public String getContent(){
        return this.messageContent;
    }
    
    
}
