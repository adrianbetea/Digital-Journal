package Pages;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPage extends JFrame implements ActionListener, MouseListener {
    // database connection
    private Connection con;

    private static RegisterPage instance;

    private JPanel login_pane;
    private JLabel register_label;

    private JPanel email_panel;
    private JLabel email_label;
    private JTextField email_field;

    private JPanel username_panel;
    private JLabel username_label;
    private JTextField username_field;

    private JPanel password_panel;
    private JLabel password_label;
    private JPasswordField password_field;

    private JButton register_button;

    private JButton have_an_account_button;

    public RegisterPage(Connection con) {
        // Set Database Connection
        this.con = con;

        // Register Frame
        this.setTitle("Login");
        this.setSize(450, 550);
        this.setResizable(false);
        this.setLayout((LayoutManager)null);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.getContentPane().setBackground(new Color(138, 70, 182));

        // Register Label
        this.register_label = new JLabel("REGISTER");
        this.register_label.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        this.register_label.setBounds(140, 10, 250,100);
        this.register_label.setForeground(Color.black);

        // Email Panel
        this.email_panel = new JPanel();
        this.email_panel.setLayout(new GridLayout(1,2,0,5));
        this.email_panel.setBounds(20, 100, 400, 50);
        this.email_panel.setBackground(Color.LIGHT_GRAY);

        // Email Label
        this.email_label = new JLabel("EMAIL ADDRESS:");
        this.email_label.setFont(new Font(Font.DIALOG,  0, 18));
        this.email_label.setHorizontalAlignment(JLabel.CENTER);

        // Email Field
        this.email_field = new JTextField();
        this.email_field.setFont(new Font(Font.DIALOG,  0, 12));
        this.email_field.setBorder(null);
        this.email_field.setHorizontalAlignment(JTextField.CENTER);

        // Username Panel
        this.username_panel = new JPanel();
        this.username_panel.setLayout(new GridLayout(1,2,0,5));
        this.username_panel.setBounds(20, 175, 400, 50);
        this.username_panel.setBackground(Color.LIGHT_GRAY);

        // Username Label
        this.username_label = new JLabel("USERNAME:");
        this.username_label.setFont(new Font(Font.DIALOG,  0, 18));
        this.username_label.setHorizontalAlignment(JLabel.CENTER);

        // Username Field
        this.username_field = new JTextField();
        this.username_field.setFont(new Font(Font.DIALOG,  0, 12));
        this.username_field.setBorder(null);
        this.username_field.setHorizontalAlignment(JTextField.CENTER);

        // Password Panel
        this.password_panel = new JPanel();
        this.password_panel.setLayout(new GridLayout(1,2,0,5));
        this.password_panel.setBounds(20, 250, 400, 50);
        this.password_panel.setBackground(Color.LIGHT_GRAY);

        // Password Label
        this.password_label = new JLabel("PASSWORD:");
        this.password_label.setFont(new Font(Font.DIALOG,  0, 18));
        this.password_label.setHorizontalAlignment(JLabel.CENTER);

        // Password Field
        this.password_field = new JPasswordField();
        this.password_field.setFont(new Font(Font.DIALOG,  0, 12));
        this.password_field.setPreferredSize(new Dimension(200, 48));
        this.password_field.setBorder(null);
        this.password_field.setHorizontalAlignment(JPasswordField.CENTER);

        // Add components to Email Panel
        this.email_panel.add(this.email_label);
        this.email_panel.add(this.email_field);

        // Add components to Username Panel
        this.username_panel.add(this.username_label);
        this.username_panel.add(this.username_field);

        // Add components to Password Panel
        this.password_panel.add(this.password_label);
        this.password_panel.add(this.password_field);

        // Login BUTTON
        this.register_button = new JButton();
        this.register_button.setText("Create new account");
        this.register_button.setBounds(90, 350, 250,50);
        this.register_button.setFont(new Font(Font.DIALOG,  Font.BOLD, 16));
        this.register_button.setFocusable(false);
        this.register_button.addActionListener(this);

        // Go to login page
        this.have_an_account_button = new JButton("Already have An Account? Go go LOGIN");
        this.have_an_account_button.setBounds(70, 420, 300, 50);
        this.have_an_account_button.setFont(new Font(Font.DIALOG,  0, 14));
        this.have_an_account_button.setForeground(Color.BLACK);
        this.have_an_account_button.setFocusable(false);
        this.have_an_account_button.setBorderPainted(false);
        this.have_an_account_button.setContentAreaFilled(false);
        this.have_an_account_button.addActionListener(this);
        this.have_an_account_button.addMouseListener(this);

        // Add components to frame
        this.add(register_label);
        this.add(email_panel);
        this.add(username_panel);
        this.add(password_panel);
        this.add(register_button);
        this.add(have_an_account_button);

        this.setVisible(true);
    }

    public static RegisterPage getInstance(Connection con) {
        if(instance == null) {
            instance = new RegisterPage(con);
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.register_button) {
            String email_text_field = email_field.getText();
            // Check if email address is valid
            Pattern email_pattern = Pattern.compile("[A-Za-z0-9.]*@[a-z]*[.]com");
            Matcher matcher = email_pattern.matcher(email_text_field);

            // if the email address is not valid throw error message and return from method
            if(matcher.find() == false) {
                JOptionPane.showMessageDialog(null, "Invalid Email Address","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            String username_text_field = username_field.getText();
            String password_text_field = String.valueOf(password_field.getPassword());

            String select_users_query = "SELECT * FROM users WHERE users.username = '"+username_text_field+"' AND users.email = '"+email_text_field+"'";
            try (Statement st = con.createStatement();){

                ResultSet rs = st.executeQuery(select_users_query);

                // if user already exists show dialog and exit method
                while(rs.next()) {
                    JOptionPane.showMessageDialog(null, "User already exists","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Insert user in database
                String insert_user_query = "INSERT INTO users(username, password, email) VALUES('"+username_text_field+"','"+password_text_field+"','"+email_text_field+"')";
                st.executeUpdate(insert_user_query);
                this.dispose();
                LoginPage.getInstance(con).setVisible(true);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == this.have_an_account_button) {
            this.dispose();
            LoginPage.getInstance(con).setVisible(true);
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
        if(e.getSource() == this.have_an_account_button) {
            this.have_an_account_button.setForeground(Color.lightGray);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.have_an_account_button) {
            this.have_an_account_button.setForeground(Color.black);
        }
    }
}
