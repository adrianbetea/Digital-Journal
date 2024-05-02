package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Dimension2D;

public class LoginPage extends JFrame implements ActionListener {

    private JPanel login_pane;
    private JLabel login_label;

    private JPanel username_panel;
    private JLabel username_label;
    private JTextField username_field;

    private JPanel password_panel;
    private JLabel password_label;
    private JPasswordField password_field;

    private JButton login_button;

    public LoginPage() {
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
        //this.login_button.setBorderPainted(false);
        //this.login_button.setContentAreaFilled(false);

        // Add components to frame
        this.add(login_label);
        this.add(username_panel);
        this.add(password_panel);
        this.add(login_button);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
