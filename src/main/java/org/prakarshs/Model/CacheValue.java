package org.prakarshs.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CacheValue<V> {
    private V value;
    private long expiryTime;

    public boolean isExpired(){
        return System.currentTimeMillis() > expiryTime;
    }
}
