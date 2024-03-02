import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Disabled
    public void testTodo(){
        Assertions.fail();
    }

}
