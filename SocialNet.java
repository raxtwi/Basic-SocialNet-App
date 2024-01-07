/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnet;

/**
 *
 * @author EnisBugra
 */
public class SocialNet {

    public static void main(String[] args) {
        users a = new users("Enis Bugra","raxtwi","12345","01.01.01",'m',"0500 123 4567","enis@gmail.com");
        System.out.println("=============================");
        
        users b = new users("Ali" ,"ali123","12345","12.12.02",'m',"0500 012 3456","ali@gmail.com");        
        System.out.println("=============================");
        
        users c = new users("Ahmet Mehmet","ahmet123","12345","02.02.02",'m',"0500 234 5678","ahmet@gmail.com");
        System.out.println("=============================");
        
        a.logIn("raxtwi", "12345");
        System.out.println("=============================");
        
        a.follow(b); 
        System.out.println("=============================");        
        a.follow(c);
        System.out.println("=============================");
        a.getFollowedIndex();
        b.getFollowedIndex();
        c.getFollowedIndex();
        System.out.println("=============================");
        a.getFollowerIndex();
        b.getFollowerIndex();
        c.getFollowerIndex();
        
        System.out.println("=============================");        
        a.sendMessage("HELLO ", b);
        b.readMessages(0);
        
        System.out.println("=============================");
        b.sendMessage("HELLO USER C", c);
        
        System.out.println("=============================");
        b.logIn("ali123", "12345");
        
        System.out.println("=============================");
        b.follow(c);
        
        System.out.println("=============================");
        b.sendMessage("HELLO", a);//hata var burda arkadas ekli olmamasına ragmen gönderiyor.isFriend 1 kere true olduktan sonra herkese mesaj atabiliyor.yukarda c yi takip etti ama a'ya mesaj atabiliyor.
        a.readMessages(0);
        
        System.out.println("=============================");
        b.sendMessage("HELLO", c);
        c.readMessages(0);
        /*b.sendMessage("HELLO", a);//hata var burda arkadas ekli olmamasına ragmen gönderiyor
        a.readMessages(0);*/
        
        System.out.println("==============================");
        a.sharePost("HELLO EVERYONE");
        a.seePost(0);
        
        b.likePost(a, 0);
        a.sharePost("HELLO ENIS");
        a.seePost(1);
        
        
        b.shareComment("WELCOME !", a, 0);
        
        System.out.println("=============================");
        a.getFollowedIndex();
        b.getFollowedIndex();
        c.getFollowedIndex();
        System.out.println("=============================");
        a.getFollowerIndex();
        b.getFollowerIndex();
        c.getFollowerIndex();
        System.out.println("=============================");
        a.profile();
        b.sharePost("HI EVERYONE");
        b.seePost(0);
        c.logIn("ahmet123","12345");
        b.follow(a);
        c.follow(a);//burda c kimseyi takip etmedigi icin post paylaşabiliyordu ama yazdırınca hata alıyorduk.isFriend true olduktan sonra paylaşabildik.
        c.sharePost("JAVA 12345");
        c.seePost(0);
        System.out.println("=============================");
        a.getFollowedIndex();
        b.getFollowedIndex();
        c.getFollowedIndex();
        System.out.println("=============================");
        a.getFollowerIndex();
        b.getFollowerIndex();
        c.getFollowerIndex();
        System.out.println("=============================");
        c.follow(b);
        System.out.println("=============================");
        a.getFollowedIndex();
        b.getFollowedIndex();
        c.getFollowedIndex();
        System.out.println("=============================");
        a.getFollowerIndex();
        b.getFollowerIndex();
        c.getFollowerIndex();
        System.out.println("");
        a.timeLine();
        c.likePost(a, 1);
        System.out.println("=============================");
        a.seePost(1);
        System.out.println("=============================");
        /*c.shareComment("Users sınıfındaki method ile yapılan comment - array içinde kaydedilmiyor sonradan ulaşılamıyor kayboluyor -- ilkel yöntem ile yapılan yorum ", a, 1);
        System.out.println("=============================");*/
        c.shareComment1("Object orianted ile ilk kullanıcıdan yapılan comment (yorum1)", a, 0);
        System.out.println("=============================");
        b.shareComment1("Object orianted ile farklı kullanıcıdan yapılan comment (yorum2)", a, 0);
        System.out.println("=============================");
        a.shareComment1("User a kendi 1. postuna yorum yapabiliyor mu", a, 0);
        System.out.println("=============================");
        a.shareComment1("User a kendi 2. postuna yorum yapabiliyor mu", a, 1);
        System.out.println("=============================");
        b.justSeeAllComments(a, 0);
        System.out.println("=============================");
        a.timeLine();
        
        
        
        
        
        
        
        
        }
        
        
        
        
        
        
        
        
        
    
    
}
