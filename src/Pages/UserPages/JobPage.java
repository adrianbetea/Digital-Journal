package Pages.UserPages;

import Pages.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobPage extends JFrame implements ActionListener, Page {

    // Singleton Instance
    private static JobPage instance;

    // User Session
    private int user_session;

    public static JobPage getInstance() {
        if (JobPage.instance == null) {
            instance = new JobPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void setSession(int session_id) {
        this.user_session = session_id;
    }

    @Override
    public int getSession() {
        return this.user_session;
    }
}