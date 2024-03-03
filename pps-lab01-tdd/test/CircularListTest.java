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
        for(int i = 0; i < 5; i++) {
            this.circularList.add(1);
        }
        assertEquals(5, this.circularList.size());
    }

    @Test
    void nextElementTest() {
        this.circularList.add(1);
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    void pickLastElementWithNextTest() {
        for(int i = 0; i < 5; i++) {
            this.circularList.add(i);
        }
        for(int i = 0; i < 4; i++) {
            this.circularList.next();
        }
        assertEquals(Optional.of(4), this.circularList.next());
    }

    @Test
    void pickElementExceedingListSizeTest() {
        for(int i = 0; i < 5; i++) {
            this.circularList.add(i);
            this.circularList.next();
        }
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    void resetListIndexTest() {
        for(int i = 0; i < 5; i++) {
            this.circularList.add(i);
            this.circularList.next();
        }
        this.circularList.reset();
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    void previousElementTest() {
        for(int i = 0; i < 5; i++) {
            this.circularList.add(i);
            this.circularList.next();
        }
        assertEquals(Optional.of(3), this.circularList.previous());
    }

}
