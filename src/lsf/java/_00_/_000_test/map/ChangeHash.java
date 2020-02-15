package lsf.java._00_._000_test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scolphew
 */
class ChangeHash {
    public static void main(String[] args) {
        Map<Hash,String> map = new HashMap<>();
        Hash h1 = new Hash();
        Hash h2 = new Hash();
        //System.out.println(h1.hashCode());
        //System.out.println(h2.hashCode());
        h1.setI(5);
        h2.setI(5);
        map.put(h1,"123");
        map.put(h2,"456");

        System.out.println(h1==h2);
        System.out.println(h1.equals(h2));

        System.out.println(map.get(h1));
        System.out.println(map.get(h2));

        System.out.println(h1.hashCode()+" "+h2.hashCode());
        System.out.println(h1+" "+h2);

        System.out.println("------------------");
        System.out.println(h1.hashCode());
        map.put(h1,"123");
        h1.setI(3);
        System.out.println(map.containsKey(h1));
        //System.out.println(h1.hashCode());
        System.out.println(map.get(h1));

        System.out.println("------------------");
        h1.setI(5);
        map.put(h1,"123");
        h1.setI(10);
        System.out.println(map.get(h1));
        h1.setI(13);
        System.out.println(map.get(h1));
        h1.setI(10);
        System.out.println(map.get(h1));

    }

}
class Hash {
    private int i;
    private int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public int hashCode() {
        return (i+j)%5;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Hash)) {
            return false;
        }else {
            Hash other = (Hash)obj;
            return this.i == other.i && this.j == other.j;
        }
    }
}
