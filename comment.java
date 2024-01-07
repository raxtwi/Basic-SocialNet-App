/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnet;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EnisBugra
 */
public class comment {
    public String commentContent;
    public users owner;
    public post p;
    private Date time;
    public ArrayList<Date> commentTimes;
    
    
    public comment(String commentContent, users owner, post p){
        this.commentContent = commentContent;
        this.owner = owner;
        this.p = p;
        this.time = new Date();
        this.commentTimes = new ArrayList<Date>();
        
    }
    
    public String getCommentContent(){
        return this.commentContent;
    }
    
    public void makeComment(){
        p.addComment(this);      
    } 
    
    public Date getTime(){
        return this.time;        
    }
    
    public void addCommentTime(){
        this.commentTimes.add(this.getTime());              
    }
    
    
}
