package foodOrder.users;

import foodOrder.exceptions.*;
import java.util.*;

public class UserManager {
    
    private static UserManager manager;
    private static Map<String, User> users;
    
    private UserManager(){};

    public static UserManager getInstance(){
        if( manager == null){
            manager = new UserManager();
            users = new HashMap<>();
        }
        return manager;
    }

    public User getUser( String userId ) throws UserNotFoundException{
        if( users.keySet().contains(userId)){
            return users.get(userId);
        }else{
            throw new UserNotFoundException();
        }
    }

    public void addUser( User user){
        users.put( user.getId(), user);
    }
}
