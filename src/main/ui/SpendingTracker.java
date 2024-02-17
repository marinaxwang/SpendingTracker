package ui;

import model.Category;
import model.Expense;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;


public class SpendingTracker {

    private Scanner input;
    private ArrayList<Category> categories;
    private ArrayList<User> users;

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
        users = new ArrayList<User>();
    }


    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a spending category");
        System.out.println("\tb -> add an expense");
        System.out.println("\tc -> add an user");
        System.out.println("\td -> see list of users");
        System.out.println("\te -> see list of spending categories");
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
            addUser();
        } else if (command.equals("d")) {
            seeListOfUsers();
        } else if (command.equals("e")) {
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
        if (!categories.isEmpty() && !users.isEmpty()) {
            //Category
            int categoryIndex = 0;

            Category category = findCategoryForExpense(categoryIndex);

            //Expense amount
            System.out.print("Enter the expense amount\n");
            double amount = input.nextDouble();
            if (amount > category.remainingAmountToSpend()) {
                System.out.print("You exceeded the limit!");
                //System.out.println(amount - (category.getBudget() - category.getAmountSpent() + amount));
            } else {
                int userIndex = 0;

                User user = findUserForExpense(userIndex);

                //create new expense
                Expense e = new Expense(category, amount, user);

                //add expense to its category's list of expenses
                category.addExpense(e);
                System.out.print("amount: " + category.getAmountSpent());
            }
        } else {
            checkEmptyArrays();
        }
    }

    private void checkEmptyArrays() {
        if (categories.isEmpty()) {
            System.out.print("Please add a spending category first!\n");
        } else if (users.isEmpty()) {
            System.out.print("Please add a user first!\n");
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

    private User findUserForExpense(int userIndex) {
        System.out.print("Enter the person who used this expense\n");
        String userName = input.next();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(userName)) {
                userIndex = i;
                break;
            }
        }
        User user = users.get(userIndex);
        return user;
    }

    private void addUser() {
        System.out.print("Enter the name of the user you wish to add\n");
        String name = input.next();

        boolean userAlreadyRegistered = false;
        for (User u : users) {
            if (u.getName().equals(name)) {
                userAlreadyRegistered = true;
                break;
            }
        }

        if (userAlreadyRegistered) {
            System.out.print("This user is already registered.\n");
        } else {
            User newUser = new User(name);
            users.add(newUser);
            System.out.print(name + " added successfully!\n");
        }

    }

    private void seeListOfUsers() {
        if (!users.isEmpty()) {
            System.out.print("Here is the list of users:\n");
            for (User u : users) {
                System.out.print("\t" + u.getName() + "\n");
            }
        } else {
            System.out.print("There is currently no users.\n");
        }
    }

    private void seeListOfCategories() {
        if (!categories.isEmpty()) {
            System.out.print("Here is a list of your spending categories:\n");
            for (Category c : categories) {
                System.out.print("\t" + c.getName() + "\n");
            }
        } else {
            System.out.print("You currently have no spending category.\n");
        }
    }
}
