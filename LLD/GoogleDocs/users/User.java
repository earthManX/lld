package GoogleDocs.users;
import java.util.*;

import GoogleDocs.documents.*;
public class User implements Observer {

    private Map<Integer, Access> access;
    private Integer userId;

    User(int id){
        this.userId = id;
        access = new HashMap<>();
    }

    public Map<Integer, Access> getAccess() {
        return access;
    }

    public void setAccess(Map<Integer, Access> access) {
        this.access = access;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void notify(String message) {
       System.out.println(message);
    }
    
}
