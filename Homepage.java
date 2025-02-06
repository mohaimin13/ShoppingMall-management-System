package GUI;
import Entity.*;
import EntityList.*;
import File.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame implements ActionListener
{	
	JButton btnproductManager,logout,transactionHistory,employManagement,sellManager;
	//BoxList boxList;
	Font font = new Font("cambria", Font.PLAIN, 20);
	LoginPage login;
	String userName;
	ProductList products;
	TransactionList transaction;
	EmployList employs;
	public Homepage(LoginPage login, String userName){
		super("Homepage");
		this.login = login;
		this.userName = userName;
		//this.boxList = boxList;
        this.setSize(400, 300);
        this.setLocation(300, 200);
        this.setLayout(null);
		this.getContentPane().setBackground(new Color(0,0,0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon productManagerim = new ImageIcon("./RES/productManager.png");
		btnproductManager = new JButton("",productManagerim);
        btnproductManager.setBounds(100, 10, 200, 35);
        btnproductManager.setFont(font);
        btnproductManager.setBackground(new Color(237,139,7));
        btnproductManager.addActionListener(this);
        this.add(btnproductManager);
		
		ImageIcon sellManagerim = new ImageIcon("./RES/sellManager.png");
		sellManager = new JButton("",sellManagerim);
        sellManager.setBounds(100, 60, 200, 35);
        sellManager.setFont(font);
        sellManager.setBackground(new Color(237,139,7));
        sellManager.addActionListener(this);
        this.add(sellManager);
		
		
		ImageIcon transactionHistoryim = new ImageIcon("./RES/transactionHistory.png");
		transactionHistory = new JButton("",transactionHistoryim);
        transactionHistory.setBounds(100, 110, 200, 35);
        transactionHistory.setFont(font);
        transactionHistory.setBackground(new Color(237,139,7));
        transactionHistory.addActionListener(this);
        this.add(transactionHistory);
		
		
		ImageIcon employManagementim = new ImageIcon("./RES/employManagement.png");
		employManagement = new JButton("",employManagementim);
        employManagement.setBounds(100, 160, 200, 35);
        employManagement.setFont(font);
        employManagement.setBackground(new Color(237,139,7));
        employManagement.addActionListener(this);
        this.add(employManagement);
		
		logout = new JButton("Logout");
        logout.setBounds(240, 220, 120, 30);
        logout.setFont(font);
		logout.setBackground(new Color(255,0,0));
		logout.setForeground(new Color(255,255,255));
        logout.addActionListener(this);
        this.add(logout);
		
		
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(btnproductManager == e.getSource()){
			products = new ProductList();
			FileIO.loadProductsFromFile(products,"./File/products.txt");
			ProductManager cm = new ProductManager(this,products);
			this.setVisible(false);
		}
		if(logout == e.getSource()){
			int option = JOptionPane.showConfirmDialog(this,"You will be Logged Out?");
			if(option == JOptionPane.YES_OPTION){
				this.dispose();
				login.setVisible(true);
			}
		}
		if( sellManager == e.getSource()){
			products = new ProductList();
			FileIO.loadProductsFromFile(products,"./File/products.txt");
			SalesManager cm = new SalesManager(this,products,userName);
			this.setVisible(false);
			
			
			
		}
			if(employManagement == e.getSource()){
			employs = new EmployList();
			FileIO.loadEmploysFromFile(employs,"./File/employ.txt");
			EmployManager cm2 = new EmployManager(this,employs);
			this.setVisible(false);
			
			
			
		}
		if(transactionHistory == e.getSource()){
			transaction = new TransactionList();
			FileIO.loadTransactionFromFile(transaction,"./File/transaction.txt");
			TransactionHistory cm = new TransactionHistory(this,transaction);
			this.setVisible(false);
		}
		
        
    }
	//.............//
	
	
}