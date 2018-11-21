/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import UserService.User;

/**
 *
 * @author Hans
 */
public class Controller {

    public User findFriends(String firstName, String lastName, String userName) {

        return new User();
    }

    public void seeProfile() {

    }

    public void sendFriendRequest(int friendId) {

    }
    public boolean replyToFriendRequest(){
        return false;
    }

    public String sendChatMessage(String message) {

        return "";
    }
    public Boolean changeSettings(){
        return false;
    }
    public String postPublicMessage(String message){
        return "";
    }
    
}
