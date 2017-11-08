package lsf.java._385_MiniParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scolphew
 */
public class NestedInteger {
    // Constructor initializes an empty nested list.
    private boolean isInt;
    private int i;
    private List<NestedInteger> list;

    public NestedInteger() {
        isInt = false;
        list = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        isInt = true;
        i = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isInt;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return i;
    }

    // Set this NestedInteger to hold a single integer.
    //public void setInteger(int value) {
    //
    //}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public String toString() {
        if (isInt) {
            return Integer.toString(i);
        } else {
            return list.toString();
        }
    }
}
