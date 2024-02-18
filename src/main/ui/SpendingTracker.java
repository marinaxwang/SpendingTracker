package ui;

import model.Category;
import model.Expense;

import java.util.ArrayList;
import java.util.Scanner;


public class SpendingTracker {

    private Scanner input;
    private ArrayList<Category> categories;

    public SpendingTracker() {
        runTracker();
    }

    private void runTracker() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    private void init() {
        input = new Scanner(System.in);
        categories = new ArrayList<Category>();
    }


    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a spending category");
        System.out.println("\tb -> add an expense");
        System.out.println("\tc -> see list of spending categories");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addCategory();
        } else if (command.equals("b")) {
            addExpense();
        } else if (command.equals("c")) {
            seeListOfCategories();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    private void addCategory() {
        System.out.print("Enter the name of the spending category you wish to add\n");
        String name = input.next();
        System.out.print("Enter the budget for " + name + "\n");
        double budget = input.nextDouble();

        Category c = new Category(name, budget);
        categories.add(c);
        System.out.print(name + " is added to your list!\n");

    }

    // MODIFIES: this
    private void addExpense() {
        if (!categories.isEmpty()) {
            //Category
            int categoryIndex = 0;

            Category category = findCategoryForExpense(categoryIndex);

            //Expense amount
            System.out.print("Enter the expense amount\n");
            double amount = input.nextDouble();
            category.addExpenseofTypeDouble(amount);
            if (category.getAmountSpent() > category.getBudget()) {
                System.out.print("You exceeded the limit by " + (category.getAmountSpent() - category.getBudget()));
            }
            //create new expense
            Expense e = new Expense(category, amount);

            //add expense to its category's list of expenses
            category.addExpense(e);

            System.out.print("\nAmount Spent: " + category.getAmountSpent());
            System.out.print("\nBudget: " + category.getBudget());
        } else {
            checkEmptyArrays();
        }
    }

    private void checkEmptyArrays() {
        if (categories.isEmpty()) {
            System.out.print("Please add a spending category first!\n");
        }
    }


    private Category findCategoryForExpense(int categoryIndex) {
        System.out.print("Here is a list of current categories, type the category name for this expense\n");
        for (Category c : categories) {
            System.out.print("\t" + c.getName() + "\n");
        }

        String categoryName = input.next();

        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equals(categoryName)) {
                categoryIndex = i;
                break;
            }
        }
        Category category = categories.get(categoryIndex);
        return category;
    }

    private void seeListOfCategories() {
        if (!categories.isEmpty()) {
            System.out.print("Here is a list of your spending categories:\n");
            for (Category c : categories) {
                System.out.print("\t" + c.getName() + "\n");
            }

            System.out.print("Enter name of the category to see its list of expenses: \n");
            String categoryName = input.next();

            boolean categoryExists = false;
            for (Category c : categories) {
                if (categoryName.equals(c.getName())) {
                    System.out.print(c.listOfExpenses() + "\n");
                    categoryExists = true;
                    break;
                }
            }
            if (!categoryExists) {
                System.out.print("THe category you entered does not exist. \n");
            }


        } else {
            System.out.print("You currently have no spending category.\n");
        }
    }
}
