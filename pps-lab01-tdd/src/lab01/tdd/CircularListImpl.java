package lab01.tdd;

import lab01.tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List circularList;
    private int listIndex;

    public CircularListImpl() {
        this.circularList = new ArrayList();
        listIndex = -1;
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
    public Optional<Integer> next() {
        this.listIndex++;
        if(this.listIndex >= this.size()) {
            this.reset();
            this.listIndex++;
        }
        return Optional.of((Integer) this.circularList.get(this.listIndex));
    }

    @Override
    public Optional<Integer> previous() {
        this.listIndex--;
        if(this.listIndex < 0) {
            this.reset();
            this.listIndex = this.circularList.size();
            this.listIndex--;
        }
        return Optional.of((Integer) this.circularList.get(this.listIndex));
    }

    @Override
    public void reset() {
        this.listIndex = -1;
    }
}
