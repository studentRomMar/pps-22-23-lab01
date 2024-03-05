package lab01.tdd.step2;

import java.util.ArrayList;
import java.util.Iterator;
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
    public Iterator<Optional<Integer>> forwardIterator() {
        return new Iterator<Optional<Integer>>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Optional<Integer> next() {
                Optional<Integer> value;
                if(circularList.isEmpty()) {
                    value = Optional.empty();
                } else {
                    value = Optional.of(circularList.get(index));
                    setIndex();
                }

                return value;
            }

            private void setIndex() {
                index = (index + 1 >= circularList.size() ? 0 : index + 1);
            }
        };
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        return new Iterator<Optional<Integer>>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Optional<Integer> next() {
                return Optional.empty();
            }
        };
    }
}
