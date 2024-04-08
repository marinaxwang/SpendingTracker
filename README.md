# My Personal Project: Spending Tracker

## Summary
This Spending Tracker will help you set a budget, keep track of your expenses, and assist you in reaching your
financial goals.
This application is designed mainly for teenagers and university students who want to budget all of their spending 
and develop better spending habits.
If you are looking to track a shared budget, perhaps with your partner, for a group project, or with your family, 
this spending tracker will help you keep track of who spent what.

The reason why I chose to develop this project is because I want to be on top of my finances. 
As a university student, I often find myself in situations where I feel like I am spending too much, 
I don't know where my money is going, or that it is troublesome to keep track of shared spending for a group of people.
I believe that this project will not only be beneficial for myself but also for other people who 
feel the same way about their finances.


**Main Features:**
- Set budget for spending categories
- Track expenses and income in categories
- Add different spending categories
- See a list of expenses in a category
- Save your changes made to spending categories and expenses

## User Stories
- As a user, I want to be able to add a spending category to a list of spending categories
- As a user, I want to be able to select a spending category and set a budget for that category
- As a user, I want to be able to add an expense, select a category, add a note,
and select a person who spent that amount to a spending category
- As a user, I want to be able to select a spending category and list all the expenses in that category
- As a user, I want to be able to save the changes I made to spending categories to file.
- As a user, when I start the application, I want to be given the option to load my spending categories from file.

## Phase 4: Task 2
Mon Apr 08 05:25:03 PDT 2024

$120 added to grocery

Mon Apr 08 05:25:12 PDT 2024

$45 added to gas

Mon Apr 08 05:25:13 PDT 2024

expense removed!

Mon Apr 08 05:25:24 PDT 2024

$12 added to uber
Z
Mon Apr 08 05:25:26 PDT 2024

expense removed!

Mon Apr 08 05:25:26 PDT 2024

expense removed!


## Phase 4: Task 3
If I had more time to work on the project, I would refactor the structure of the model package. Instead of having
the user directly access a list of categories, I would make an Account class that holds the list of categories.
Each Category class would then hold a list of expenses. This refactoring process would make the structure easier to
implement the JSON file and GUI.