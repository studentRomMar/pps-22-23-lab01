import lab01.tdd.step3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularListFilteredNextTest {

    private CircularList circularList;

    @BeforeEach
    public void createList() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void createCorrectlyListTest() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void assertEmptyListSizeTest() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    public void multipleElementsInListSizeTest() {
        for(int i = 0; i < 5; i++) {
            this.circularList.add(i);
        }
        assertEquals(5, this.circularList.size());
    }
}
