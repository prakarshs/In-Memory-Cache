package org.prakarshs.Implementations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Interfaces.CacheInterface;

import java.util.concurrent.ConcurrentHashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheIMPL<K,V> implements CacheInterface<K,V> {
    ConcurrentHashMap<K,>
    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void clear() {

    }
}
