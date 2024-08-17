package LLD.Library;
import java.util.*;
import java.util.stream.*;

public class Library {
    // lookup by id, author and name
    Map<String, Artifact> idMap;
    Map<String, List<Book>> authorMap;
    Map<String, List<Artifact>> nameMap;

    Library(){
        idMap = new HashMap<>();
        authorMap = new HashMap<>();
        nameMap = new HashMap<>();
    }

    public void registerBook( String name, String id, String author){
        Book book = new Book(name, id, author);
        idMap.putIfAbsent(id, book );
        authorMap.getOrDefault(author, new ArrayList<Book>()).add(book);
        nameMap.getOrDefault(name, new ArrayList<Artifact>()).add(book);
    }

    public void registerMagazine(String name, String id, int issue){
        Magazine mag = new Magazine(name, id, issue);
        idMap.putIfAbsent(id, mag );
        // authorMap.getOrDefault(author, new ArrayList<Book>()).add(book);
        nameMap.getOrDefault(name, new ArrayList<Artifact>()).add(mag);
    }

    public List<Artifact> lookUpName( String name){
        if(nameMap.size() != 0 ){
            return nameMap.getOrDefault(name, new ArrayList<>());
        }
        return new ArrayList<>();
    }

    public List<Book> lookUpAuthor( String author){
        if(authorMap.size() != 0 ){
            return authorMap.getOrDefault(author, new ArrayList<>());
        }
        return new ArrayList<>();
    }

    public Optional<Artifact> lookUpId( String id){
        if(idMap.size() != 0 ){
            return Optional.of(idMap.getOrDefault(id, null));
        }
        return Optional.empty();
    }

}