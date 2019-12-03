package java.hw.countmap;

import java.util.*;

public class CountMapImpl<K> implements CountMap<K> {
    HashMap<K, Integer> map = new HashMap<>();
    @Override
    public void add(K key) {
        if (!map.containsKey(key))
            map.put(key, 0);
        map.put(key, map.get(key)+1);
    }


    @Override
    public int getCount(K key) {
        return map.get(key);
    }

    @Override
    public int remove(K key) {
        return map.remove(key);
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public Map<K, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super K, Integer> destination) {
        for (K key: map.keySet()){
            destination.put(key, map.get(key));
        }
    }


    @Override
    public void addAll(CountMap<? extends K> countMap) {
        for (K key:countMap.toMap().keySet()){
            if (!map.containsKey(key)){
                map.put(key, countMap.toMap().get(key));
            }
            else {
                map.put(key, map.get(key)+countMap.toMap().get(key));
            }
        }
    }


}
