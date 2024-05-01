package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame implements ActionListener, Page {
    private UniversityPage university_page;
    private GymPage gym_page;
    private FamilyPage family_page;
    private JobPage job_page;
    private ActivitiesPage activities_page;
    private JournalingPage journaling_page;

    private String page_name = "Main Page";
    private ImageIcon main_page_icon = new ImageIcon("resources/interface images/main_page_logo.png");
    public MainPage() {
        this.university_page = UniversityPage.getInstance();
        this.gym_page = new GymPage();
        this.family_page = new FamilyPage();
        this.job_page = new JobPage();
        this.activities_page = new ActivitiesPage();

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



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
