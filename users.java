/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EnisBugra
 */
public class users {

    private String name;
    private String userName;
    private String password;
    private String birthDay;    
    private String phoneNumber;
    private String email;
    private char gender;
    private boolean isOnline;
    private boolean isFriend;    
    private int followerIndex = 0;
    private int followedIndex = 0;
    private int messageCount;
    private int postCount = 0;
    private int likeCount = 0;
    private int viewCount = 0;
    private int commentCount = 0;
    private ArrayList<users> followers = new ArrayList<>();
    private ArrayList<users> followedPeople = new ArrayList<>();
    private ArrayList<message> inbox = new ArrayList<>();
    private ArrayList<post> postInbox = new ArrayList<>();
    private ArrayList<String> commentInbox = new ArrayList<>();
    
    

    public users(String name, String userName, String password, String birthDay, char gender, String phoneNumber, String email) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.birthDay = birthDay;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isOnline = false;               
        writeAttributes();
    }

    public void writeAttributes() {
        System.out.println("Name : " + this.name);
        System.out.println("userName : " + this.userName);
        System.out.println("password : " + this.password);
        System.out.println("birthDay : " + this.birthDay);
        System.out.println("gender : " + this.gender);
        System.out.println("phoneNumber : " + this.phoneNumber);
        System.out.println("email : " + this.email);
        System.out.println("is account online ? : " + this.isOnline);

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void getEmail(String email) {
        this.email = email;
    }

    public boolean getIsOnline() {
        return this.isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public int getFollowedIndex() {
        System.out.println("You are (" + this.getName() + ") following " + this.followedIndex + " people.");
        return this.followedIndex;
    }

    public int getFollowerIndex() {
        System.out.println("You (" + this.getName() + ") have " + this.followerIndex + " follower(s).");
        return this.followerIndex;
    }

    public boolean logIn(String userName, String password) {
        if (userName.equals(this.userName) && password.equals(this.password)) {
            this.isOnline = true;
            System.out.println(this.name + " has succesfully logged in.");
            System.out.println("");
        } else {
            this.isOnline = false;
            System.out.println("Error ! Your username-password is incorrect !");
            System.out.println("");
        }
        return this.isOnline;
    } //Hoca ile yaptığımız method buydu.Alttakini kendim yaptım.

    /*public void logIn(String userName , String password){
        if(userName.equals(this.userName) && password.equals(this.password)){
            this.isOnline = true;
            System.out.println("Login is succesfull !");
        }
        else {
            this.isOnline = false;
            System.out.println("Error ! Your username-password is incorrect !");
        }
        
    }*/
    public void follow(users a) {
        if (this.isOnline) {        
            
            a.getFollowed(this);
            this.followedPeople.add(a);
            System.out.println("You (" + this.name + ") are following the user " + this.followedPeople.get(followedIndex).name + " succesfully !");
            System.out.println("");
            this.isFriend = true;   
            this.followedIndex++;    
        }
        else {
            System.out.println("Please login for following !");
            System.out.println("");
        }
    }

    public void getFollowed(users a) {
                
        this.followers.add(a);
        System.out.println("User " + this.followers.get(followerIndex).name + " has followed you (" + this.name + ") !");
        System.out.println("");
        this.followerIndex++;
         
    }

    public void sendMessage(String messageContent, users receiver) {
        message m = new message(messageContent, this, receiver);
        if (this.isOnline) {

            if (this.isFriend) {//is friend 1 kere true olduktan sonra takip etmediği kişilere bile mesaj gönderebiliyor 
                System.out.println("User " + this.name + " sent a message to " + receiver.name + " :");
                System.out.println("");
                m.sendMessage();
            } else {
                System.out.println("Message could not be sent.");
                System.out.println("");
                System.out.println("You (" + this.name + ") have to follow the user " + receiver.name);
            }
        } else {
            System.out.println("You (" + this.name + ") have to login to send a message !");
            System.out.println("");
        }
    }

    /*public void sendMessage(String messageContent, users receiver) { //bu method calismiyor nedenini bilmiyorum 212. satır ile ilgili hata veriyor
        message m = new message(messageContent, this, receiver);
        if (this.isOnline) {
            for (int i = 0; i <= receiver.followers.size(); i++) {
                for (int j = 0; j <= this.followedPeople.size(); j++) {

                    if (this.followedPeople.get(j).name.equals(receiver.followers.get(i).name)) {//is friend 1 kere true olduktan sonra takip etmediği kişilere bile mesaj gönderebiliyor (social net satır 52 53)
                        System.out.println("User " + this.name + " sent a message to " + receiver.name + " :");
                        m.sendMessage();
                    } else { //bu else'de mantık hatası var silinmesi gerekiyor)(users[] default değerleri ne oluyor)
                        System.out.println("Message could not be sent.");
                        System.out.println("You (" + this.name + ") have to follow the user " + receiver.name);
                    }
                }
            }
        } else {
            System.out.println("You (" + this.name + ") have to login to send a message !");
        }
    }*/
    
    public boolean receiveMessage(message m) {
        this.inbox.add(m);
        this.messageCount++;
        return true;         
    }

    public void readMessages(int index) {
        System.out.println(inbox.get(index).getContent());
        inbox.get(index).setSeen();
    }   
           
    
    public void sharePost(String postContent){
        post p = new post(postContent,this);
        if (this.isOnline) {
            if (this.isFriend) {//is friend 1 kere true olduktan sonra takip etmediği kişilerin postlarını bile görebiliyor
                System.out.println("User " + this.name + " just shared a post !");
                System.out.println("");
                p.sharePost();  
                p.addPostTime();                
            } 
        }  
        else {
            System.out.println("You (" + this.name + ") have to login to send a message !");
            System.out.println("");
        }
    }
    
    public boolean postPage(post p){
        this.postInbox.add(p);
        this.postCount++;
        return true;         
    }
    
    public void seePost(int index){
        System.out.println(postInbox.get(index).getPost());
        System.out.println(postInbox.get(index).postTimes);
        System.out.println("");
    }
    
    /*public void seePostTime(int index){
        System.out.println(postInbox[index].postTimes);    
    }*/
    
    public void likePost(users postSender , int index){
        System.out.println("The user "+ this.name + " liked your ("+ postSender.name + "'s) " +(index+1) + ". post.");
        System.out.println("");
        this.likeCount++;
    }
    
    public boolean commentPage(String c){        
        this.commentInbox.add(c);
        this.commentCount++;
        return true;        
    }
    
    public void shareComment1(String commentContent , users postSender , int index0){
        comment c = new comment(commentContent , this , postSender.postInbox.get(index0));
        postSender.postInbox.get(index0).addComment(c);
        System.out.println("You " + this.name + " shared a comment successfully ! (Your comment is '" + commentContent + "'.)");
        System.out.println("The user "+ this.name + " commented "+ postSender.name + "'s " +(index0+1) + ". post.");
        System.out.println("");
        /*System.out.println("Here the all comments about this post : ");
        postSender.postInbox.get(index0).writeAllComments();*/
        Scanner input = new Scanner(System.in);
        String yes = "y";
        String no = "n";
        System.out.println("Do you want to see other comments about this post ? For yes/no : press y/n button ");
        String istek = input.nextLine();
        if(istek.equals(yes)){
            postSender.postInbox.get(index0).writeAllComments();            
        }
        else{
        }
    }
    
    public void justSeeAllComments(users a ,int index1){
        System.out.println("The all comments about the user " + a.name + "'s " + (index1+1) + ". post : ");  
        System.out.println("");
        a.postInbox.get(index1).writeAllComments();        
    }
    
    public void shareComment(String commentContent , users postSender , int index0){
        String c = commentContent;
        System.out.println("The user "+ this.name + " commented your ("+ postSender.name + "'s) " +(index0+1) + ". post :");
        System.out.println("");
        System.out.println(c);
        System.out.println("");
        }
          
    public void profile(){
        System.out.println("The user " + this.name + " posted :");
        System.out.println("");
        for(int i = postInbox.size()-1 ; i >= 0 ; i--){            
            System.out.println(postInbox.get(i).getPost() + postInbox.get(i).postTimes);//normalde System.out.println(postInbox.get(i).getPost() + postInbox.get(i).postTimes.get(i)); olması gerekiyor ama 2 tarihte aynı olduğu için time arrayinde sadece 1 eleman o da programı çalıştırdığım tarih oluyor
            System.out.println("");
        }
    }
    
    public void timeLine(){
        System.out.println("==========THE USER " + this.name + "'s TIMELINE===========");
        for(int i = followedPeople.size()-1 ; i >= 0  ; i--){
            followedPeople.get(i).profile();            
        }
    }
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


