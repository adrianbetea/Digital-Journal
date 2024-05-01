package Pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JournalingPage extends JFrame implements ActionListener, Page {

    private static JournalingPage instance;

    public static JournalingPage getInstance() {
        if (JournalingPage.instance == null) {
            instance = new JournalingPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}