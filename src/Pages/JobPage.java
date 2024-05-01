package Pages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobPage extends JFrame implements ActionListener, Page {

    private static JobPage instance;

    public static JobPage getInstance() {
        if (JobPage.instance == null) {
            instance = new JobPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}