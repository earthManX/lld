package LLD.Library;

public class Magazine extends Artifact {

    private int issue;

    Magazine(String name, String id, int issue){
        super.name = name;
        super.id = id;
        this.issue = issue;
        super.isRented = false;
    }
}
