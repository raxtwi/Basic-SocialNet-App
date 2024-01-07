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
public class post {
    
    private String postContent;    
    private Date time;
    private ArrayList<users> whoLiked = new ArrayList<>();//bunları yapamadım 1
    private ArrayList<users> whoComment = new ArrayList<>();
    private users postSender;    
    private String commentContent;
    public ArrayList<comment> coms;   
    public ArrayList<Date> postTimes;
    
    
    public post(String postContent, users postSender){
        this.postContent = postContent;
        this.postSender = postSender;
        this.time = new Date();
        this.postTimes = new ArrayList<Date>();
        this.coms = new ArrayList<comment>();
    }
    
    
    public boolean sharePost(){
        return this.postSender.postPage(this);
    }
    
    public String getPost(){
        return this.postContent;
    }
    
    public Date getTime(){
        return this.time;        
    }
    
    public void addPostTime(){
        this.postTimes.add(this.getTime());              
    }
       
    
    public void comment(String commentContent){//bu ve altındaki benim yaptıgım comment
        this.commentContent = commentContent;
    }
    
    public String getCommend(){
        return this.commentContent;
    }
    
    public void addComment(comment c){//bu ve altındaki + comment sınıfı hocayla yaptıgımız
        coms.add(c);
    }
    
    public void writeAllComments(){
        for(int i = 0 ; i < coms.size() ; i++){
            System.out.println("Comment " + (i+1) + " : " + this.coms.get(i).getCommentContent());
                        
        }
    } 
}
