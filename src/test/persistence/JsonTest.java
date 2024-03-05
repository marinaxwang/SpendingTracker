package persistence;

import model.Category;
import model.Expense;
import model.ListOfCategories;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkExpenses(String name, double amount, Category expense) {
        assertEquals(name, expense.getName());
        assertEquals(amount, expense.getBudget());
    }
}
