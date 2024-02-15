package model;

public class Category {
    private Double budget;
    private Double amountSpent;

    public Category(Double budget) {
        this.budget = budget;
        amountSpent = 0.0;
    }



    public Double getBudget() {
        return budget;
    }

    public Double getAmountSpent() {
        return amountSpent;
    }
}
