package LLD.DS;

public class DoublyLinkedList<T> {
    
    LLNode<T> head;
    LLNode<T> tail;
    int size;

    public DoublyLinkedList(T headValue, T tailValue){
        head = new LLNode<T>(headValue);
        tail = new LLNode<T>(tailValue);
        head.next = tail;
        tail.prev = head;
        size = 2;
    }

    public DoublyLinkedList(int size){
        if( size < 1 ){
            head = null;
            tail = null;
        }
        if( size == 1){
            head = new LLNode<T>();
        }
        head = new LLNode<T>();
        size--;
        LLNode<T> prev = head;
        while( size != 1 ){
            size--;
            LLNode<T> next = new LLNode<>();
            prev.next = next;
            next.prev = prev;
            prev = next;
        }
        tail = new LLNode<T>();
        prev.next = tail;
        tail.prev = prev;
        this.size = size;
    }

    public LLNode<T> getHead(){
        return head;
    }

    public LLNode<T> getTail(){
        return tail;
    }

    public LLNode<T> getElement( T value ){
        if( head.value.equals(value)){
            return head;
        }
        LLNode<T> next = head.next;
        while( !next.value.equals(next) ){
            if( next.equals(tail)){
                return null;
            }
            next = next.next;
        }
        return next;
    }

    public void addInFront(LLNode<T> node){
        node.next = head;
        node.prev = null;
        head.prev = node;
        size++;
    }    

    public void removeFromTail(){
        LLNode<T> last = tail.prev;
        last.next = null;
        size--;
    }

    public void removeElement(LLNode<T> node){
        LLNode<T> nodePrev = node.prev;
        LLNode<T> nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        size--;
    }

    public int getSize(){
        return size;
    }
}
