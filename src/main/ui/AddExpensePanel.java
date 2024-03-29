package ui;

import ui.components.AddExpenseButton;

import javax.swing.*;
import java.awt.*;

public class AddExpensePanel extends JPanel {
    private SpendingTracker st;
    AddExpenseButton button;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;

    public AddExpensePanel(SpendingTracker st) {
        button = new AddExpenseButton(st, this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

}
