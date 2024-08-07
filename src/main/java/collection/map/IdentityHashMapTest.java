package collection.map;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap<Object, String> map = new IdentityHashMap<>();
        Object key1 = new Object();
        Object key2 = new Object();
        map.put(key1, "value1");
        map.put(key2, "value2");  // Different from key1 despite identical content

    }
}
