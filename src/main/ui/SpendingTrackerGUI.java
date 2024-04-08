package ui;

import javax.swing.*;
import java.awt.*;
//TODO
public class SpendingTrackerGUI extends JFrame {

    private SpendingTracker st;
    private AddExpensePanel expensePanel;
    private AddMenuPanel menuPanel;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public SpendingTrackerGUI() {
        super("Spending Tracker");
        st = new SpendingTracker();
        expensePanel = new AddExpensePanel(st);
        menuPanel = new AddMenuPanel(st);

        add(expensePanel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.SOUTH);

        st.setExpensePanel(expensePanel);
        st.setMenuPanel(menuPanel);

        setSize(WIDTH, HEIGHT);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SpendingTrackerGUI();
    }
}
