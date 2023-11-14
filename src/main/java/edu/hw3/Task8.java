package edu.hw3;

import java.util.Iterator;
import java.util.List;

public class Task8<T> implements Iterator<T> {

    private List<T> list;
    private int current;

    public Task8(List<T> list) {
        this.list = list;
        this.current = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return current >= 0;
    }

    @Override
    public T next() {
        T element = list.get(current);
        current--;
        return element;
    }
}
