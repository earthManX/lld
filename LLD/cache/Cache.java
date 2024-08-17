package LLD.cache;

import java.util.Optional;

public interface Cache<K,V> {
    void addElement(K key, V value);
    Optional<CacheElement<K,V>> getElement( K key);
}
