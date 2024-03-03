import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    private void initializeCircularListWithElements(CircularList list) {
        for(int i = 0; i < 5; i++) {
            list.add(i);
        }
    }

    private void carryAlongIteratorAndInitializeList(CircularList list) {
        for(int i = 0; i < 5; i++) {
            list.add(i);
            list.next();
        }
    }

    @BeforeEach
    void createCircularList() {
        this.circularList = new CircularListImpl();
    }

    @Test
    void circularListSizeTest() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    void isListEmptyTest() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void addElementToListTest() {
        this.circularList.add(1);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void addMultipleElementsToListTest() {
        this.initializeCircularListWithElements(this.circularList);
        assertEquals(5, this.circularList.size());
    }

    @Test
    void nextElementTest() {
        this.circularList.add(1);
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    void pickLastElementWithNextTest() {
        this.initializeCircularListWithElements(this.circularList);
        for(int i = 0; i < 4; i++) {
            this.circularList.next();
        }
        assertEquals(Optional.of(4), this.circularList.next());
    }

    @Test
    void pickElementExceedingListSizeTest() {
        this.carryAlongIteratorAndInitializeList(this.circularList);
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    void resetListIndexTest() {
        this.carryAlongIteratorAndInitializeList(this.circularList);

        this.circularList.reset();
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    void previousElementTest() {
        this.carryAlongIteratorAndInitializeList(this.circularList);
        assertEquals(Optional.of(3), this.circularList.previous());
    }

    @Test
    void pickElementExceedingBackwardsListTest() {
        this.carryAlongIteratorAndInitializeList(this.circularList);
        for(int i = 5; i > 0; i--) {
            this.circularList.previous();
        }
        assertEquals(Optional.of(3), this.circularList.previous());
    }

}
