package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseTest {
    private Expense e;
    private Category c1;

    @BeforeEach
    void runBefore() {
        c1 = new Category("Food", 100);
        e = new Expense(c1, 20);
    }

    @Test
    void testConstructor() {
        assertEquals(c1, e.getCategory());
        assertEquals(20, e.getAmount());
    }
}
