package GUI;
import File.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    
    JPanel panel;
    JLabel userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn, regBtn;
    
    Font font = new Font("arial", Font.BOLD, 25);
    
    public LoginPage() {
        super("Login Page");
        initialization();
        
        //=========Login========//
        //User Name
        userLabel = new JLabel("User Name");
        userLabel.setBounds(40, 50, 200, 40);
        userLabel.setFont(font);
        userLabel.setForeground(new Color(237, 139, 7));
        panel.add(userLabel);
        
        userField = new JTextField("elman");
        userField.setBounds(240, 50, 200, 40);
        userField.setFont(font);
        panel.add(userField);
        
        //Password
        passLabel = new JLabel("Password");
        passLabel.setBounds(40, 130, 200, 40);
        passLabel.setFont(font);
        passLabel.setForeground(new Color(237, 139, 7));
        panel.add(passLabel);
        
        passField = new JPasswordField("1234");
        passField.setBounds(240, 130, 200, 40);
        passField.setFont(font);
        passField.setEchoChar('*');
        panel.add(passField);
        
        //Login Button
        ImageIcon loginimg = new ImageIcon("./RES/login.png");
        loginBtn = new JButton("", loginimg);
        loginBtn.setBounds(50, 200, 200, 40);
        loginBtn.setFont(font);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);
        
        ImageIcon regimg = new ImageIcon("./RES/register.png");
        regBtn = new JButton("", regimg);
        regBtn.setBounds(270, 200, 200, 40);
        regBtn.setFont(font);
        regBtn.addActionListener(this);
        panel.add(regBtn);
        
        //======================//
        this.setVisible(true);
    }
    
    public void initialization() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLayout(null);
        this.setLocation(400, 200);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 400);
        panel.setBackground(new Color(0, 0, 0));
        this.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = userField.getText();
        String userPass = String.valueOf(passField.getPassword());
        
        if (loginBtn == e.getSource()) {
            int status = FileIO.checkUserLogin("./File/users.txt", userName, userPass);
            if (status == 1) {
                System.out.println(userName + " " + " is Verified");
                Homepage hp = new Homepage(this, userName);
                this.setVisible(false);
                userField.setText("");
                passField.setText("");
            } else if (status == 2) {
                JOptionPane.showMessageDialog(this, "Invalid Password", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (regBtn == e.getSource()) {
            this.setVisible(false);
            new RegistrationPage(this);
        }
    }
}