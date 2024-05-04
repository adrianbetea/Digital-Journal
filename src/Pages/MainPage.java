package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame implements ActionListener, Page {
    // Singleton Class
    private static MainPage instance;


    private String page_name = "Main Page";
    private ImageIcon main_page_icon = new ImageIcon("resources/interface images/main_page_logo.png");
    public MainPage() {
        UniversityPage.getInstance();
        GymPage.getInstance();
        FamilyPage.getInstance();
        JobPage.getInstance();
        ActivitiesPage.getInstance();

        this.setTitle(page_name="Main Page");
        this.setSize(700, 800);
        this.setResizable(false);
        this.setLayout(new GridLayout(3, 2, 2, 2));
        this.setIconImage(this.main_page_icon.getImage());
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.getContentPane().setBackground(new Color(4786533));
        this.setVisible(true);
    }

    public static MainPage getInstance() {
        if (instance == null) {
            instance = new MainPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
