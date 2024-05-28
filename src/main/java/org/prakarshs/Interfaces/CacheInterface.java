package org.prakarshs.Interfaces;
public interface CacheInterface<K,V> {
    void put(K key,V value);
    V get(K key);
    void remove(K key);
    void clear();
    int getSize();
    void evict();
}
