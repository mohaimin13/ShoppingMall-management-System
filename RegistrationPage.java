package GUI;

import File.FileIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationPage extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton regBtn, backBtn;
    private Font font = new Font("arial", Font.BOLD, 25);
    private LoginPage loginPage;

    public RegistrationPage(LoginPage loginPage) {
        super("Registration Page");
        this.loginPage = loginPage;
        initialization();
        createUI();
    }

    private void initialization() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 400);
        panel.setBackground(new Color(0, 0, 0));
        this.add(panel);
    }

    private void createUI() {
        // Username components
        userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 50, 200, 40);
        userLabel.setFont(font);
        userLabel.setForeground(new Color(237, 139, 7));
        panel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(240, 50, 200, 40);
        userField.setFont(font);
        panel.add(userField);

        // Password components
        passLabel = new JLabel("Password:");
        passLabel.setBounds(40, 130, 200, 40);
        passLabel.setFont(font);
        passLabel.setForeground(new Color(237, 139, 7));
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(240, 130, 200, 40);
        passField.setFont(font);
        passField.setEchoChar('*');
        panel.add(passField);

        // Register Button
        ImageIcon regImg = new ImageIcon("./RES/register.png");
        regBtn = new JButton("", regImg);
        regBtn.setBounds(150, 200, 200, 40);
        regBtn.setFont(font);
        regBtn.addActionListener(this);
        panel.add(regBtn);

        // Back Button
        backBtn = new JButton("Back to Login");
        backBtn.setBounds(150, 260, 200, 30);
        backBtn.setFont(new Font("arial", Font.PLAIN, 18));
        backBtn.setBackground(new Color(50, 50, 50));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regBtn) {
            String userName = userField.getText();
            String userPass = new String(passField.getPassword());

            if (userName.isEmpty() || userPass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (FileIO.registerUser("./File/users.txt", userName, userPass)) {
                JOptionPane.showMessageDialog(this, "Registration Successful!");
                this.dispose();
                loginPage.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else if (e.getSource() == backBtn) {
            this.dispose();
            loginPage.setVisible(true);
        }
    }
}