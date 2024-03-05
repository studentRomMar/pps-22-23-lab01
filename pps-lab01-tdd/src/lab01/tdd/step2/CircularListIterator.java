package lab01.tdd.step2;

import java.util.Iterator;
import java.util.Optional;

public class CircularListIterator implements Iterator<Optional<Integer>> {

    private int index;
    private int listSize;

    public CircularListIterator(int listSize) {
        this.listSize = listSize;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Optional<Integer> next() {

        return null;
    }
}
