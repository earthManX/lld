package LLD.DS;

public class LLNode<T> {
    T value;
    LLNode<T> prev;
    LLNode<T> next;

    public LLNode(){}
    
    public LLNode( T value ){
        this.prev = null;
        this.next = null;
        this.value = value;
    }

    public LLNode(LLNode<T> prev, LLNode<T> next, T value){
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public T getValue(){
        return value;
    }
}
