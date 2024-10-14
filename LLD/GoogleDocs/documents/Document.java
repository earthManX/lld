package GoogleDocs.documents;

import java.util.*;

import GoogleDocs.users.*;
import GoogleDocs.users.Observer;

public class Document {
    private Map< Integer, Access> accessMap ;
    private String content;
    private int version;
    private Map<Integer, String> versions;
    private Map< Observer, State> observers;
    private Integer id; 

    Document(int id){
        this.id = id;
        accessMap = new HashMap<>();
        version = 0;
        versions = new HashMap<>(); 
        observers = new HashMap<>();
    }

    public void edit(String edit, int userId){
        versions.put(version, content);
        version++;
        content = edit;
        observers.forEach(( k , v ) -> {
            if( !v.equals(State.IDLE)){
                k.notify("Content for document " + id + " is edited by user " + userId) ;
            }
        });
    }

    public Integer getId() {
        return id;
    }
    public Map<Integer, Access> getAccessMap() {
        return accessMap;
    }
    public void setAccessMap(Map<Integer, Access> accessMap) {
        this.accessMap = accessMap;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public Map<Integer, String> getVersions() {
        return versions;
    }
    public void setVersions(Map<Integer, String> versions) {
        this.versions = versions;
    }
    public Map<Observer, State> getObservers() {
        return observers;
    }
    public void setObservers(Map<Observer, State> observers) {
        this.observers = observers;
    }
}
