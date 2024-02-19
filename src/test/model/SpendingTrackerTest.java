package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.SpendingTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpendingTrackerTest {
    private SpendingTracker tracker;
    private Category c1;
    private Category c2;
    private Expense e1;
    private Expense e2;
    private Expense e3;
    private Expense e4;

    void runBefore() {
        tracker = new SpendingTracker();
        c1 = new Category("Food", 100);
        c2 = new Category("Play", 150);
        e1 = new Expense(c1, 20);
        e2 = new Expense(c1, 30);
        e3 = new Expense(c1, 50);
        e4 = new Expense(c1, 40);
    }

    @Test
    void testConstructor() {
        //assertTrue(tracker.getCategories().isEmpty());
    }

    @Test
    void testRunTracker() {
        //assertTrue(tracker.getCategories().isEmpty());
        //assertEquals("Select from:\n" + "\ta -> add a spending category\n" + "\tb -> add an expense\n" +
              //  "\tc -> see list of spending categories\n" +
            //    "\tq -> quit", tracker.runTracker());
    }

    @Test
    void testDisplayMenu() {

    }

    @Test
    void testProcessCommand() {

    }

    @Test
    void testAddCategory() {

    }

    @Test
    void testAddExpense() {
    }


    @Test
    void testCheckEmptyArrays() {

    }

    @Test
    void testFindCategoryForExpense() {

    }

    @Test
    void testSeeListOfCategories() {

    }

    @Test
    void testGetCategoryReport() {

    }
}
