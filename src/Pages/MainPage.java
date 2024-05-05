package Pages;

import database.DatabaseConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainPage extends JFrame implements ActionListener, Page {
    // Singleton Instance
    private static MainPage instance;

    // Database Connection
    private static Connection con;

    // User Session
    private int user_session;

    // Pages Buttons
    private JButton open_university_page;
    private JButton open_gym_page;
    private JButton open_family_page;
    private JButton open_job_page;
    private JButton open_activities_page;
    private JButton open_journaling_page;

    private ImageIcon main_page_icon = new ImageIcon("resources/interface images/main_page_logo.png");
    public MainPage() {
        // Set Database Connection
        this.con = DatabaseConnectionManager.getInstance().getConnection();

        // init main page
        this.setTitle("Main Page");
        this.setSize(700, 800);
        this.setResizable(false);
        this.setLayout(new GridLayout(3, 2, 2, 2));
        this.setIconImage(this.main_page_icon.getImage());
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.getContentPane().setBackground(new Color(4786533));


        // init page components
        // using private methods from this class to not overfill the constructor
        init_university_button();
        init_gym_page();
        init_family_page();
        init_job_page();
        init_activities_page();
        init_journaling_page();

        this.add(open_university_page);
        this.add(open_gym_page);
        this.add(open_family_page);
        this.add(open_job_page);
        this.add(open_activities_page);
        this.add(open_journaling_page);

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

        String query = "SELECT * FROM users WHERE users.user_id = '"+this.user_session+"'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                // if credentials are ok go to main page
                String user = rs.getString("username");
                System.out.println("Hello " + user);
            }

            // opens UserPages
            if(e.getSource() == open_university_page) {

            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public void setSession(int session_id) {
        this.user_session = session_id;
    }

    @Override
    public int getSession() {
        return this.user_session;
    }

    private void init_university_button() {
        this.open_university_page = new JButton();
        this.open_university_page.setText("University");
        this.open_university_page.setIcon(null);
        this.open_university_page.setFont(new Font("Serif", 1, 30));
        this.open_university_page.setForeground(Color.BLACK);
        this.open_university_page.setFocusable(false);
        this.open_university_page.setBorder(BorderFactory.createEtchedBorder());
        this.open_university_page.setBackground(new Color(5405111));
        this.open_university_page.addActionListener(this);
    }

    private void init_gym_page() {
        this.open_gym_page = new JButton();
        this.open_gym_page.setText("Gym");
        this.open_gym_page.setIcon(null);
        this.open_gym_page.setFont(new Font("Monospaced", 1, 36));
        this.open_gym_page.setForeground(Color.BLACK);
        this.open_gym_page.setFocusable(false);
        this.open_gym_page.setBorder(BorderFactory.createEtchedBorder());
        this.open_gym_page.setBackground(new Color(3480488));
        this.open_gym_page.setHorizontalTextPosition(2);
        this.open_gym_page.addActionListener(this);
    }

    private void init_family_page() {
        this.open_family_page = new JButton();
        this.open_family_page.setText("Family");
        this.open_family_page.setIcon(null);
        this.open_family_page.setFont(new Font("Dialog", 1, 30));
        this.open_family_page.setForeground(Color.BLACK);
        this.open_family_page.setFocusable(false);
        this.open_family_page.setBorder(BorderFactory.createEtchedBorder());
        this.open_family_page.setBackground(new Color(4724129));
        this.open_family_page.addActionListener(this);
    }

    private void init_job_page() {
        this.open_job_page = new JButton();
        this.open_job_page.setText("Friends");
        this.open_job_page.setIcon(null);
        this.open_job_page.setFont(new Font("Dialog", 2, 36));
        this.open_job_page.setForeground(Color.BLACK);
        this.open_job_page.setFocusable(false);
        this.open_job_page.setBorder(BorderFactory.createEtchedBorder());
        this.open_job_page.setBackground(new Color(3214448));
        this.open_job_page.setHorizontalTextPosition(2);
        this.open_job_page.addActionListener(this);
    }

    private void init_activities_page() {
        this.open_activities_page = new JButton();
        this.open_activities_page.setText("Activities");
        this.open_activities_page.setIcon(null);
        this.open_activities_page.setFont(new Font("Monospaced", 2, 36));
        this.open_activities_page.setForeground(Color.BLACK);
        this.open_activities_page.setFocusable(false);
        this.open_activities_page.setBorder(BorderFactory.createEtchedBorder());
        this.open_activities_page.setBackground(new Color(5448062));
        this.open_activities_page.addActionListener(this);
    }

    private void init_journaling_page() {
        this.open_journaling_page = new JButton();
        this.open_journaling_page.setText("Journaling");
        this.open_journaling_page.setIcon(null);
        this.open_journaling_page.setFont(new Font("Serif", 2, 38));
        this.open_journaling_page.setForeground(Color.BLACK);
        this.open_journaling_page.setFocusable(false);
        this.open_journaling_page.setBorder(BorderFactory.createEtchedBorder());
        this.open_journaling_page.setBackground(new Color(7017103));
        this.open_journaling_page.setHorizontalTextPosition(2);
        this.open_journaling_page.addActionListener(this);
    }
}
