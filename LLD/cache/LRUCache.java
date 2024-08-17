package LLD.cache;

import java.util.*;
import LLD.DS.*;

public class LRUCache<K, V> implements Cache<K , V> {

    DoublyLinkedList<CacheElement<K,V>> cacheQ;
    Map< K, LLNode<CacheElement<K,V>> > cacheMap;
    int size;

    LRUCache( int size){
        this.size = size;
        cacheQ = new DoublyLinkedList<CacheElement<K,V>>(size);
    }

    @Override
    public void addElement(K key, V value) {
        // Cache is already full
        LLNode<CacheElement<K,V>> newNode = new LLNode<CacheElement<K,V>>(new CacheElement<K,V>(key, value));
        if(cacheQ.getSize() == size){
            cacheQ.removeFromTail();
        }
        // Cache has space
        cacheQ.addInFront(newNode);
        cacheMap.put(key, newNode);
    }

    @Override
    public Optional<CacheElement<K, V>> getElement(K key) {
        //Cache hit
        if( cacheMap.containsKey(key)){
            LLNode<CacheElement<K,V>> node = cacheMap.get(key);
            cacheQ.removeElement(node);
            cacheQ.addInFront(node);
            cacheMap.put(key, node);
            // Bring element in front of cache
            return Optional.of(new CacheElement<K,V>(key, node.getValue().getValue()));
        }else{
            // Cache miss
            return Optional.empty();
        }
    }
    
}
