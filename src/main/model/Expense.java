package model;

// Represents an expense having a category and an amount
public class Expense {
    private Category category;
    private double amount;

    // EFFECTS: constructs an expense with a category and an amount
    public Expense(Category c, double a) {
        category = c;
        amount = a;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

}
