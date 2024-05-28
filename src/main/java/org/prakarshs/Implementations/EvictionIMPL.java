package org.prakarshs.Implementations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Interfaces.EvictionInterface;

import java.util.LinkedHashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvictionIMPL<K> implements EvictionInterface<K> {
    private LinkedHashMap<K,Boolean> accessOrder;
    @Override
    public void keyAccessed(K key) {
        accessOrder.put(key, Boolean.TRUE);
    }

    @Override
    public K evict() {
        K leastRecentlyUsed = accessOrder.keySet().iterator().next();
        accessOrder.remove(leastRecentlyUsed);
        return leastRecentlyUsed;
    }
}
