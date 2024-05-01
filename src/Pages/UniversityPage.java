package Pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniversityPage extends JFrame implements ActionListener, Page {

    private static UniversityPage instance;

    public static UniversityPage getInstance() {
        if (UniversityPage.instance == null) {
            instance = new UniversityPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
