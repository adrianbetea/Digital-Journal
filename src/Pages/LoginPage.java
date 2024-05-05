package Pages;

import database.DatabaseConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPage extends JFrame implements ActionListener, MouseListener, Page {
    // database connection
    private static Connection con;

    // User session
    private int user_session;

    private static LoginPage instance;

    private JPanel login_pane;
    private JLabel login_label;

    private JPanel username_panel;
    private JLabel username_label;
    private JTextField username_field;

    private JPanel password_panel;
    private JLabel password_label;
    private JPasswordField password_field;

    private JButton login_button;

    private JButton dont_have_an_account_button;

    public LoginPage() {
        // Set Database Connection
        this.con = DatabaseConnectionManager.getInstance().getConnection();


        // Login Frame
        this.setTitle("Login");
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLayout((LayoutManager)null);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.getContentPane().setBackground(new Color(138, 70, 182));

        // Login Label
        this.login_label = new JLabel("LOGIN");
        this.login_label.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        this.login_label.setBounds(150, 10, 100,100);
        this.login_label.setForeground(Color.black);

        // Username Panel
        this.username_panel = new JPanel();
        this.username_panel.setLayout(new GridLayout(1,2,0,5));
        this.username_panel.setBounds(25, 125, 330, 50);
        this.username_panel.setBackground(Color.LIGHT_GRAY);

        // Username Label
        this.username_label = new JLabel("USERNAME:");
        this.username_label.setFont(new Font(Font.DIALOG,  0, 18));
        this.username_label.setHorizontalAlignment(JLabel.CENTER);

        // Username Field
        this.username_field = new JTextField();
        this.username_field.setFont(new Font(Font.DIALOG,  0, 18));
        this.username_field.setBorder(null);
        this.username_field.setHorizontalAlignment(JTextField.CENTER);

        // Password Panel
        this.password_panel = new JPanel();
        this.password_panel.setLayout(new GridLayout(1,2,0,5));
        this.password_panel.setBounds(25, 200, 330, 50);
        this.password_panel.setBackground(Color.LIGHT_GRAY);

        // Password Label
        this.password_label = new JLabel("PASSWORD:");
        this.password_label.setFont(new Font(Font.DIALOG,  0, 18));
        this.password_label.setHorizontalAlignment(JLabel.CENTER);

        // Password Field
        this.password_field = new JPasswordField();
        this.password_field.setFont(new Font(Font.DIALOG,  0, 18));
        this.password_field.setPreferredSize(new Dimension(200, 48));
        this.password_field.setBorder(null);
        this.password_field.setHorizontalAlignment(JPasswordField.CENTER);

        // Add components to Username Panel
        this.username_panel.add(this.username_label);
        this.username_panel.add(this.username_field);

        // Add components to Password Panel
        this.password_panel.add(this.password_label);
        this.password_panel.add(this.password_field);


        // Login BUTTON
        this.login_button = new JButton();
        this.login_button.setText("Login");
        this.login_button.setBounds(125, 280, 150,50);
        this.login_button.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        this.login_button.setFocusable(false);
        this.login_button.addActionListener(this);

        // Go to REGISTER PAGE
        this.dont_have_an_account_button = new JButton("Don't have an account? REGISTER NOW");
        this.dont_have_an_account_button.setBounds(20, 360, 340, 50);
        this.dont_have_an_account_button.setFont(new Font(Font.DIALOG,  0, 14));
        this.dont_have_an_account_button.setForeground(Color.BLACK);
        this.dont_have_an_account_button.setFocusable(false);
        this.dont_have_an_account_button.setBorderPainted(false);
        this.dont_have_an_account_button.setContentAreaFilled(false);
        this.dont_have_an_account_button.addActionListener(this);
        this.dont_have_an_account_button.addMouseListener(this);

        // Add components to frame
        this.add(login_label);
        this.add(username_panel);
        this.add(password_panel);
        this.add(login_button);
        this.add(dont_have_an_account_button);


        this.setVisible(true);
    }

    public static LoginPage getInstance() {
        if(instance == null) {
            instance = new LoginPage();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == this.login_button) {
            String username_fieldText = username_field.getText();
            String password_fieldText = String.valueOf(password_field.getPassword());

            String query = "SELECT * FROM users WHERE users.username = '"+username_fieldText+"' AND users.password = '"+password_fieldText+"'";
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()) {
                    // if credentials are ok go to main page
                    int id = rs.getInt("user_id");
                    String user = rs.getString("username");
                    // sets the user session
                    this.setSession(id);
                    MainPage.getInstance().setSession(id);

                    // opens main page
                    this.dispose();

                    MainPage.getInstance().setVisible(true);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == this.dont_have_an_account_button) {
            this.dispose();
            RegisterPage.getInstance().setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this.dont_have_an_account_button) {
            this.dont_have_an_account_button.setForeground(Color.lightGray);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.dont_have_an_account_button) {
            this.dont_have_an_account_button.setForeground(Color.black);
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
}
