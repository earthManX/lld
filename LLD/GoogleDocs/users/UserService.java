package GoogleDocs.users;

import java.util.*;

public class UserService {
    
    private static UserService userService;
    private static Map<Integer, User> users;

    private UserService(){}

    public static UserService getUserService(){
        if( userService == null){
            userService = new UserService();
            users = new HashMap<>();
        }
        return userService;
    }

    public int addUser(int id){
        User user = new User(id);
        users.put(id, user);
        return user.getUserId();    
    }
    
    public User getUser(int userId){
        return users.get(userId);
    }

}
