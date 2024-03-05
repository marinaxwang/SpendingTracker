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

    @Test
    void testToString() {
        assertEquals("lunch: $20.0", e.toString());
    }

    @Test
    void testToJson() {
        assertEquals("lunch", e.toJson().getString("name"));
        assertEquals(20.0, e.toJson().getDouble("amount"));
    }
}
