package lab01.tdd.step2;

import java.util.ArrayList;
import java.util.Iterator;

public class CircularListImpl implements CircularList {

    private ArrayList<Integer> circularList;

    public CircularListImpl() {
        this.circularList = new ArrayList<>();
    }

    @Override
    public void add(int element) {

    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return null;
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return null;
    }
}
