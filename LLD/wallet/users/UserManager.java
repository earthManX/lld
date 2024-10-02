package wallet.users;

import java.util.*;

public class UserManager {
    
    static UserManager userManager;
    static Map<Integer, User> users;
    private int userCounter = 0;

    private UserManager(){}

    public static UserManager getUserManagerInstance(){
        if( userManager == null){
            users = new HashMap<>();
            userManager = new UserManager();
        }
        return userManager;
    }

    public int addUser(){
        userCounter++;
        User newUser = new User(userCounter);
        users.put(userCounter, newUser);
        return newUser.getId();
    }

    public void removeUser( int id){
        //TODO
    }

    public User getUser(int id){
        return users.get(id);
    }
}
