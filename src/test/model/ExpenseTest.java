package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseTest {
    private Expense e;

    @BeforeEach
    void runBefore() {
        e = new Expense("lunch", 20);
    }

    @Test
    void testConstructor() {
        assertEquals("lunch", e.getName());
        assertEquals(20, e.getAmount());
    }
}
