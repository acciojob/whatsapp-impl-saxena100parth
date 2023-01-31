package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {

    //Assume that each user belongs to at most one group
    //You can use the below mentioned hashmaps or delete these and create your own.
    private static HashMap<Group, List<User>> groupUserMap;
    private static HashMap<Group, List<Message>> groupMessageMap;
    private static HashMap<Message, User> senderMap;
    private static HashMap<Group, User> adminMap;
    private static HashSet<User> userMobile;
    private static int customGroupCount;
    private static int messageId;
    private static HashSet<User> groupedUsers;
    private static HashSet<Message> allMessages;



    public WhatsappRepository(){
        this.groupMessageMap = new HashMap<Group, List<Message>>();
        this.groupUserMap = new HashMap<Group, List<User>>();
        this.senderMap = new HashMap<Message, User>();
        this.adminMap = new HashMap<Group, User>();
        this.userMobile = new HashSet<User>();
        this.customGroupCount = 0;
        this.messageId = 0;
        this.groupedUsers = new HashSet<User>();
        this.allMessages = new HashSet<Message>();
    }

    public static HashSet<Message> getAllMessages() {
        return allMessages;
    }

    public static HashSet<User> getGroupedUsers() {
        return groupedUsers;
    }

    public static HashMap<Group, List<User>> getGroupUserMap() {
        return groupUserMap;
    }

    public static HashMap<Group, List<Message>> getGroupMessageMap() {
        return groupMessageMap;
    }


    public static HashMap<Message, User> getSenderMap() {
        return senderMap;
    }



    public static int getMessageId() {
        return messageId;
    }
    public static void setMessageId(int messageId) {
        WhatsappRepository.messageId = messageId;
    }

    public static HashMap<Group, User> getAdminMap() {
        return adminMap;
    }


    public static HashSet<User> getUserMobile() {
        return userMobile;
    }

    public static int getCustomGroupCount() {
        return customGroupCount;
    }
    public static void setCustomGroupCount(int customGroupCount) {
        WhatsappRepository.customGroupCount = customGroupCount;
    }


}
