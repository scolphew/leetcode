package lsf._000_test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scolphew
 * @create 2016Äê08ÔÂ08ÈÕ
 */
public class MutableDemo {
    public static void main(String[] args) {

        // Object created
        MutableKey key = new MutableKey(10, 20);
        System.out.println("Hash code: " + key.hashCode());

        // Object State is changed after object creation.
        key.setI(30);
        key.setJ(40);
        System.out.println("Hash code: " + key.hashCode());

        System.out.println("------------------------------------------------");

        Map<MutableKey, String> map = new HashMap<>();
        key = new MutableKey(10, 20);
        map.put(key, "Robin");
        System.out.println(map.get(key));
        key.setI(30);
        System.out.println(map.get(key));
    }
}
