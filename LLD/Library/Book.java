package LLD.Library;

public class Book extends Artifact{

    private String author;

    Book( String name, String id, String author){
        this.author = author;
        super.id = id;
        super.name = name;
        super.isRented = false;
    }


}
