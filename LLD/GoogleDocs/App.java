package GoogleDocs;

import GoogleDocs.documents.Access;
import GoogleDocs.documents.DocumentService;
import GoogleDocs.users.UserService;

public class App {
    
    public static void main(String[] args) {
        DocumentService ds = DocumentService.getDocumentService();
        UserService us = UserService.getUserService();

        us.addUser(1);
        us.addUser(2);

        ds.createDocument(1,1);
        ds.createDocument(2, 2);

        ds.addCollaborator(1, 2, 1, Access.EDITOR);
        ds.addCollaborator(2, 1, 2, Access.VIEWER);

        ds.editDocument(1, 1);

    }
}
