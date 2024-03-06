package lab01.tdd.step3;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

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
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        Optional<Integer> value = Optional.empty();
        return value;
    }
}
