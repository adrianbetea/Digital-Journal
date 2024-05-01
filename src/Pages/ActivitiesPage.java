package Pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivitiesPage extends JFrame implements ActionListener, Page {

    private static ActivitiesPage instance;

    public static ActivitiesPage getInstance() {
        if (ActivitiesPage.instance == null) {
            instance = new ActivitiesPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}