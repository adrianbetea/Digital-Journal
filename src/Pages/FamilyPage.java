package Pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FamilyPage extends JFrame implements ActionListener, Page {

    private static FamilyPage instance;

    public static FamilyPage getInstance() {
        if (FamilyPage.instance == null) {
            instance = new FamilyPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}