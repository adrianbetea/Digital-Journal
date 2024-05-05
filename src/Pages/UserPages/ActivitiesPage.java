package Pages.UserPages;

import Pages.Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivitiesPage extends JFrame implements ActionListener, Page {

    // Singleton Instance
    private static ActivitiesPage instance;

    // User Session
    private int user_session;

    public static ActivitiesPage getInstance() {
        if (ActivitiesPage.instance == null) {
            instance = new ActivitiesPage();
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