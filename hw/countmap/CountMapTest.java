package java.hw.countmap;

import org.junit.Assert;
import org.junit.Test;

public class CountMapTest {
    @Test
    public void testAddandCount() {
        CountMap<String> countMap = new CountMapImpl<>();
        countMap.add("Ag");
        countMap.add("Egg");
        countMap.add("Ag");
        Assert.assertTrue(countMap.getCount("Ag") == 2);
        Assert.assertTrue(countMap.size()== 2);
    }
    @Test
    public void testRemove(){
        CountMap<Integer> countMap = new CountMapImpl<>();
        countMap.add(5);
        countMap.add(6);
        countMap.add(5);
        countMap.add(5);
        countMap.add(15);
        Assert.assertTrue(countMap.remove(5) == 3);
    }
    @Test
    public void testAddAll(){
        CountMap<String> countMap = new CountMapImpl<>();
        countMap.add("Ag");
        countMap.add("Egg");
        countMap.add("Ag");
        CountMap<String> countMap2 = new CountMapImpl<>();
        countMap2.addAll(countMap);
        Assert.assertEquals(countMap.toMap(), countMap2.toMap());
    }
}
