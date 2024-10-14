Reference - https://lldcoding.com/design-lld-a-real-time-collaborative-document-editing-platform-like-google-docs-machine-coding


Features Required:

Real-time Collaboration: Multiple users should be able to collaborate and edit a document simultaneously in real-time.

Document Synchronization: Changes made by one user should be immediately reflected in the document for all other users.

User Presence: Users should be able to see the presence of other users currently viewing or editing the document.

Cursor Position Tracking: Users should be able to see the cursor positions of other users in real-time.

Collaborative Text Editing: Users should be able to add, delete, and modify text in the document collaboratively.

Version History: The system should maintain a version history of the document, allowing users to revert to previous versions if needed.

Document Sharing: Users should be able to share documents with other users, granting them appropriate access permissions.

Access Controls: The system should provide access control mechanisms to manage user permissions for viewing and editing documents.

UserService
    - addUser
    - getUser

Users 
    - accessMap <Document Id, Access Level>
    - userId

Observer
    - notify()

DocumentService
    - createDocument
    - addCollaborator
    - editDocument
    - shareDocument

Document
    - accessMap<User Id, Access Level>
    - content
    - version
    - versions <version, content>
    - observersMap <observer, State>



