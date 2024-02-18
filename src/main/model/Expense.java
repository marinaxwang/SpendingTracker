package model;

public class Expense {
    private Category category;
    private double amount;


    public Expense(Category c, double a) {
        category = c;
        amount = a;
    }

    public Category getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }


}
