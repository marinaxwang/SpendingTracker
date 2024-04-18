package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategoryTest {
    private Category c;
    private Expense e1;
    private Expense e2;
    private Expense e3;
    private Expense e4;

    @BeforeEach
    void runBefore() {
        c = new Category("Food", 100);
        e1 = new Expense("lunch", 20);
        e2 = new Expense("dinner", 30);
        e3 = new Expense("snack", 50);
        e4 = new Expense("movie", 40);
    }

    @Test
    void testConstructor() {
        assertEquals("Food", c.getName());
        assertEquals(100.0, c.getBudget());
        assertEquals(0.0, c.getAmountSpent());
        assertTrue(c.getExpenses().isEmpty());
    }

    @Test
    void testListOfExpensesEmptyList() {
        assertEquals("There is no expenses under this category.", c.listOfExpenses());
    }

    @Test
    void testListOfExpensesOneExpense() {
        c.addExpense(e1);
        assertEquals("- $20.00\n", c.listOfExpenses());
    }

    @Test
    void testListOfExpensesMultipleExpenses() {
        c.addExpense(e1);
        c.addExpense(e2);
        c.addExpense(e3);
        c.addExpense(e4);

        assertEquals("- $20.00\n" + "- $30.00\n" + "- $50.00\n" + "- $40.00\n" , c.listOfExpenses());
    }

    @Test
    void testAddExpenseOneExpense() {
        assertTrue(c.getExpenses().isEmpty());
        c.addExpense(e1);
        assertEquals(e1, c.getExpenses().get(0));
    }

    @Test
    void testAddExpenseMultipleExpenses() {
        c.addExpense(e1);
        c.addExpense(e2);
        c.addExpense(e3);

        assertEquals(e1, c.getExpenses().get(0));
        assertEquals(e2, c.getExpenses().get(1));
        assertEquals(e3, c.getExpenses().get(2));

        assertEquals(20, e1.getAmount());
        assertEquals(30, e2.getAmount());
        assertEquals(50, e3.getAmount());
    }

    @Test
    void testAddExpenseOfTypeDoubleOneExpense() {
        c.addExpenseOfTypeDouble(20);
        assertEquals(20, c.getAmountSpent());
    }

    @Test
    void testAddExpenseOfTypeDoubleMultipleExpenses() {
        c.addExpenseOfTypeDouble(20);
        c.addExpenseOfTypeDouble(30);
        c.addExpenseOfTypeDouble(50);
        assertEquals(100, c.getAmountSpent());
    }
}