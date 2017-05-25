package lsf._341_FlattenNestedListIterator;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> q;

    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        foo(nestedList);
    }

    void foo(List<NestedInteger> nestedLIst) {
        for (NestedInteger e : nestedLIst) {
            if (e.isInteger()) {
                q.offer(e.getInteger());
            } else {
                foo(e.getList());
            }
        }
    }


    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return q.size() > 0;
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested q.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested q
    public Integer getInteger();

    // @return the nested q that this NestedInteger holds, if it holds a nested q
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

