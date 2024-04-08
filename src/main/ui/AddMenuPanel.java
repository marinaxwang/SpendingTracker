package ui;

import ui.components.LoadButton;
import ui.components.QuitButton;
import ui.components.SaveButton;


import javax.swing.*;
import java.awt.*;

//adds menu panel to GUI
public class AddMenuPanel extends JPanel {
    private SpendingTracker st;
    QuitButton quitButton;
    SaveButton saveButton;
    LoadButton loadButton;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 100;

    public AddMenuPanel(SpendingTracker st) {
        quitButton = new QuitButton(st, this);
        saveButton = new SaveButton(st, this);
        loadButton = new LoadButton(st, this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
