package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class WhatsappService {
    public String createUser(String name, String mobile){
        WhatsappRepository.getUserMobile().add( new User(name,mobile));
        return "SUCCESS";
    }
    public Group createGroup(List<User> users)
    {
        int userCount = users.size();
        Group group = new Group();
        group.setNumberOfParticipants(userCount);
        User admin = users.get(0);
        if(userCount==2){
            group.setName(users.get(1).getName());
        }else{
            int groupCount = WhatsappRepository.getCustomGroupCount()+1;
            WhatsappRepository.setCustomGroupCount(groupCount);
            group.setName("Group "+ groupCount);
        }
        WhatsappRepository.getGroupUserMap().put(group,users);
        WhatsappRepository.getAdminMap().put(group,admin);
        WhatsappRepository.getGroupMessageMap().put(group,new ArrayList<Message>());


        return group;
    }

    public Integer createMessage(String content){

        int ID = WhatsappRepository.getMessageId();
        ID++;
        WhatsappRepository.setMessageId(ID);
        Date date = new Date();
        WhatsappRepository.getAllMessages().add(new Message(ID,content,date));

        return ID;
    }

    public int sendMessage(Message message, User sender, Group group){
        WhatsappRepository.getSenderMap().put(message,sender);
        WhatsappRepository.getGroupMessageMap().get(group).add(message);
        WhatsappRepository.getAllMessages().add(message);
        return WhatsappRepository.getGroupMessageMap().get(group).size();

    }

    public String changeAdmin(User approver, User user, Group group){
        WhatsappRepository.getAdminMap().put(group,user);
        return "SUCCESS";
    }

    public int removeUser(User user) {
        return  0;
    }

    public String findMessage(Date start, Date end, int k) {
        return "";
    }
}
