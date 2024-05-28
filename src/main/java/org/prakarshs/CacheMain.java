package org.prakarshs;


import org.prakarshs.Implementations.CacheIMPL;
import org.prakarshs.Implementations.EvictionIMPL;
import org.prakarshs.Interfaces.CacheInterface;
import org.prakarshs.Interfaces.EvictionInterface;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CacheMain {
    public static void main(String[] args) {
        EvictionInterface<Integer> evictionInterface = new EvictionIMPL<>(new LinkedHashMap<>());
        CacheInterface<Integer, String> cacheInterface = new CacheIMPL<>(new ConcurrentHashMap<>(),evictionInterface,30000L);
        CacheManager<Integer, String> cacheManager = new CacheManager<>(cacheInterface, 5);

        cacheManager.put(1,"raju");
        cacheManager.put(2,"shyam");
        cacheManager.put(3,"baburao");
        cacheManager.put(4,"seth");
        cacheManager.put(5,"anuradha");

       System.out.println(cacheManager.get(4));
       System.out.println(cacheManager.get(1));

        cacheManager.put(6,"kabira");

        System.out.println(cacheManager.get(6));
        
    }
}