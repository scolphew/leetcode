package lsf._000_test.map;

/**
 * @author scolphew
 */
@SuppressWarnings("ALL")
public class MutableKey {
    private int i;
    private int j;

    public MutableKey(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public final int getI() {
        return i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final int getJ() {
        return j;
    }

    public final void setJ(int j) {
        this.j = j;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        result = prime * result + j;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MutableKey)) {
            return false;
        }else {
            MutableKey other = (MutableKey)obj;
            return this.i == other.i && this.j == other.j;
        }
    }
}
