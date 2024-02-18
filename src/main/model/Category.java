package model;

import java.util.ArrayList;

// Represents a spending category having a name, a budget, an amount spent, and a list of expenses
public class Category {
    private String name;
    private double budget;
    private double amountSpent;
    private ArrayList<Expense> expenses;

    // EFFECTS: construct a category with name set to parameter name, budget set to parameter budget
    //          amount spent set to 0, and a empty list of expenses
    public Category(String name, double budget) {
        this.name = name;
        this.budget = budget;
        amountSpent = 0.0;
        expenses = new ArrayList<>();
    }

    // EFFECTS: returns a string of the list of expenses
    public String listOfExpenses() {
        String allExpenses = "";
        if (expenses.isEmpty()) {
            return "There is no expenses under this category.";
        }
        for (Expense e : expenses) {
            String expenseAmount = String.format("%.2f", e.getAmount()); // get expense to 2 decimal places as string
            allExpenses += "- $" + expenseAmount + "\n";
        }

        return allExpenses;
    }

    // MODIFIES: this
    // EFFECTS: add an expense to the list of expenses
    public void addExpense(Expense e) {
        expenses.add(e);
    }

    // REQUIRES: e > 0
    // MODIFIES: this
    // EFFECTS: add the amount of parameter e to the amount spent in this category
    public void addExpenseofTypeDouble(double e) {
        amountSpent += e;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

}
