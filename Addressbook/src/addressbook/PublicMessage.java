/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import UserService.User;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hans
 */
public class PublicMessage {

    private int messageId;
    private Date dateSent;
    private String message;
    private ArrayList<User> isVisibleTo;
}
