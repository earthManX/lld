package GoogleDocs.documents;

import java.util.*;

import GoogleDocs.users.*;
import GoogleDocs.users.Observer;

public class DocumentService {
    
    private static DocumentService documentService;
    private static Map<Integer, Document> documents;
    private static UserService userService;

    private DocumentService(){}

    public static DocumentService getDocumentService(){
        if( documentService == null){
            documentService = new DocumentService();
            documents = new HashMap<>();
            userService = UserService.getUserService();
        }
        return documentService;
    }

    public void createDocument(int userId, int id){
        Document document = new Document(id);
        User user = userService.getUser(userId);
        Map< Integer, Access> accessMap = document.getAccessMap();
        accessMap.put(userId, Access.ADMIN);
        document.setAccessMap(accessMap);
        Map< Observer, State> observers = document.getObservers();
        observers.put(user, State.IDLE);
        document.setObservers(observers);
        documents.put(id, document);
    }

    public void addCollaborator(int userId, int collaboratorId, int documentId, Access access){
        Document document = documents.get(documentId);
        if( document.getAccessMap().get(userId).equals(Access.ADMIN)){
            Map< Integer, Access> accessMap = document.getAccessMap();
            accessMap.put(collaboratorId, access);
            document.setAccessMap(accessMap);
            User collaborator = userService.getUser(collaboratorId);
            Map< Observer, State> observers = document.getObservers();
            observers.put(collaborator, State.IDLE);
            document.setObservers(observers);
        }else{
            System.out.println("User not authorized to do this operation");
        }
    }

    public void editDocument(int userId, int documentId){
        Document document = documents.get(documentId);
        Map< Integer, Access> accessMap = document.getAccessMap();
        if( accessMap.get(userId).equals(Access.ADMIN) || accessMap.get(userId).equals(Access.EDITOR)){
            document.getObservers().put(userService.getUser(userId), State.EDITING);
            document.edit("Meh", userId);
        }else{
            System.out.println("User not authorized to do this operation");
        }
    }

    public void moveCursor(int userId, int documentId){

    }

    public void shareDocument( int userId, int otherUserId, Access access, int documentId){

    }

}
