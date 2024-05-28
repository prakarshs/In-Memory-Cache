package org.prakarshs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Interfaces.CacheInterface;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheManager<K,V> {
    private CacheInterface<K,V> cacheInterface;
    private long maxSize;

    void put(K key,V value){
        if(cacheInterface.getSize() >= maxSize){
            cacheInterface.evict();
        }
        else{
            cacheInterface.put(key, value);
        }
    }

    V get(K key){
        return cacheInterface.get(key);
    }

    void remove(K key){
        cacheInterface.remove(key);
    }

    void clear(){
        cacheInterface.clear();
    }

}
