package java.hw.countmap;

import java.util.Map;

public interface CountMap <K>{
    void add (K key);

    int getCount(K key);

    int remove(K key);

    int size();
    //<key,value>
    Map<K,Integer> toMap();

    void toMap(Map<? super K, Integer> destination);

    void addAll(CountMap<? extends K> map);
}
