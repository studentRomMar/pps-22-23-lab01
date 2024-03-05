package lab01.tdd.step3;

import java.util.ArrayList;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private ArrayList<Integer> circularList;

    public CircularListImpl() {
        this.circularList = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
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
    public Optional<Integer> filteredNext() {
        return Optional.empty();
    }
}
