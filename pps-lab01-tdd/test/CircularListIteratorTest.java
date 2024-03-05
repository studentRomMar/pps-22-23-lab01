import lab01.tdd.step2.CircularList;
import lab01.tdd.step2.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularListIteratorTest {

    private static final int NUM_LIST_ELEMENTS = 5;

    private CircularList circularList;


    private void initializeList(CircularList list, int numElements) {
        for(int i = 0; i < numElements; i++) {
            list.add(i);
        }
    }

    @BeforeEach
    void createCircularList() {
        this.circularList = new CircularListImpl();
    }

    @Test
    void createCorrectlyCircularListTest() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    void isListEmptyTest() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void addElementToListTest() {
        this.circularList.add(1);
        assertEquals(1, this.circularList.size());
    }

    @Test
    void addMultipleElementsToListTest() {
        this.initializeList(this.circularList, NUM_LIST_ELEMENTS);
        assertEquals(NUM_LIST_ELEMENTS, this.circularList.size());
    }

    @Test
    void ForwardIteratorTest() {
        this.initializeList(this.circularList, NUM_LIST_ELEMENTS);
        Iterator<Optional<Integer>> iterator = this.circularList.forwardIterator();
        IntStream.range(0, NUM_LIST_ELEMENTS).forEach(integer -> assertEquals(integer, iterator.next().get()));
    }

    @Test
    void forwardIteratorEmptyList() {
        Iterator<Optional<Integer>> iterator = this.circularList.forwardIterator();
        IntStream.range(0, NUM_LIST_ELEMENTS).forEach(integer -> assertEquals(Optional.empty(), iterator.next()));
    }

    @Test
    void backwardIteratorListTest() {
        this.initializeList(this.circularList, NUM_LIST_ELEMENTS);
        List<Integer> comparisonList = new ArrayList<>();
        for(int i = NUM_LIST_ELEMENTS - 1; i >= 0; i--) {
            comparisonList.add(i);
        }
        Iterator<Optional<Integer>> iterator = this.circularList.backwardIterator();
        comparisonList.forEach(integer -> assertEquals(integer, iterator.next().get()));

    }

    @Test
    void backwardIteratorEmptyListTest() {
        Iterator<Optional<Integer>> iterator = this.circularList.backwardIterator();
        IntStream.range(0, NUM_LIST_ELEMENTS).forEach(integer -> assertEquals(Optional.empty(), iterator.next()));
    }
}
