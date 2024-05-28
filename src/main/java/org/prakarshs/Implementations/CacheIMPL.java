package org.prakarshs.Implementations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Interfaces.CacheInterface;
import org.prakarshs.Interfaces.EvictionInterface;
import org.prakarshs.Model.CacheValue;

import java.util.concurrent.ConcurrentHashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheIMPL<K,V> implements CacheInterface<K,V> {
    private ConcurrentHashMap<K, CacheValue<V>> cache;
    private EvictionInterface<K> evictionInterface;
    private Long timeToLive;
    @Override
    public void put(K key, V value) {
        CacheValue<V> content = new CacheValue<>(value, System.currentTimeMillis() + timeToLive);
        cache.put(key,content);
        evictionInterface.keyAccessed(key);
    }

    @Override
    public synchronized V get(K key) {
       CacheValue<V> value =  cache.get(key);
       if(value==null || value.isExpired()){
           cache.remove(key);
           return null;
       }
       evictionInterface.keyAccessed(key);
        return value.getValue();

    }

    @Override
    public synchronized void remove(K key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int getSize() {
        return cache.size();
    }

    public void evict(){
       K keyToRemove = evictionInterface.evict();
       cache.remove(keyToRemove);
    }
}
