package LLD.cache;

public class CacheElement<K,V> {
    K key;
    V value;
    
    public CacheElement( K key, V value){
        this.key = key;
        this.value = value;
    }

    public V getValue(){
        return value;
    }
}
