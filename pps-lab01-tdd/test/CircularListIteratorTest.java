import lab01.tdd.step2.CircularList;
import lab01.tdd.step2.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularListIteratorTest {

    private CircularList circularList;

    private void initializeList(CircularList list) {
        for(int i = 0; i < 5; i++) {
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
        this.initializeList(this.circularList);
        assertEquals(5, this.circularList.size());
    }

    @Test
    void nextElementInListTest() {
        
    }
}
