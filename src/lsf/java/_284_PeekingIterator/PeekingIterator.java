package lsf.java._284_PeekingIterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Integer next = null;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        if (iter.hasNext())
            next = iter.next();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer tmp = next;
        next = iter.hasNext() ? iter.next() : null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

}
