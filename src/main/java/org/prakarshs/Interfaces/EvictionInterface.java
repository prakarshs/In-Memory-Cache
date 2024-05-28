package org.prakarshs.Interfaces;

public interface EvictionInterface<K> {
    void keyAccessed(K key);
    K evict();
}
