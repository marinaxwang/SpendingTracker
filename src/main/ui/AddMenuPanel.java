package ui;

import ui.components.QuitButton;
import ui.components.SaveButton;


import javax.swing.*;
import java.awt.*;

public class AddMenuPanel extends JPanel {
    private SpendingTracker st;
    QuitButton quitButton;
    SaveButton saveButton;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;

    public AddMenuPanel(SpendingTracker st) {
        quitButton = new QuitButton(st, this);
        saveButton = new SaveButton(st, this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
