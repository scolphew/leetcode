package lsf.java._03_._341_FlattenNestedListIterator;

import java.util.*;

public class NestedIterator2 implements Iterator<Integer> {
    Deque<NestedInteger> s;

    public NestedIterator2(List<NestedInteger> nestedList) {
        s = new ArrayDeque<>(nestedList);
        s = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return s.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!s.isEmpty() && !s.peekFirst().isInteger()) {
            List<NestedInteger> list = s.pollFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--)
                s.addFirst(list.get(i));
        }
        return !s.isEmpty();
    }
}
