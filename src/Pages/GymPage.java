package Pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GymPage extends JFrame implements ActionListener, Page {

    private static GymPage instance;

    public static GymPage getInstance() {
        if (GymPage.instance == null) {
            instance = new GymPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}