package GUI;
import Entity.*;
import EntityList.*;
import File.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class TransactionHistory extends JFrame implements ActionListener{
	
	JPanel panel;
	
	JTable table;
	DefaultTableModel model;
	
	Font font = new Font("arial",Font.BOLD,25);
	
	Homepage hp;
	TransactionList transaction;
	JButton backBtn;
	
	public TransactionHistory(Homepage hp, TransactionList transaction){
		super("Transaction Management");
		this.hp = hp;
		this.transaction = transaction;
		initialization();
		
		
		
		backBtn = new JButton("Home");
		backBtn.setBounds(580,400,150,30);
		backBtn.setFont(font);
		backBtn.setBackground(Color.RED);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		createTable();
		
		this.setVisible(true);
	}
	
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,500);
		this.setLayout(null);
		this.setLocation(200,100);
		this.setIconImage(new ImageIcon("./RES/logo.png").getImage());
		
		JLabel background = new JLabel(new ImageIcon("./RES/bg.png"));
		background.setBounds(0,0,800,500);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,500);
		
		panel.setOpaque(false);
		
		this.add(panel);
		this.add(background);
	}
	
	public void createTable(){
		model = new DefaultTableModel();
		
		model.addColumn("NAME");
		model.addColumn("PRICE");
		
		
		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setBounds(0, 0, 600, 300);
		table.setRowHeight(30);
		table.setBackground(new Color(64,128,128));
		table.setSelectionBackground(new Color(0, 0,255));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,50,600,300);
		
		ArrayList<Transaction> alltransaction = transaction.getAll();
		
		for(int i=0;i<alltransaction.size();i++){
			Transaction Transaction = alltransaction.get(i);
			model.addRow(new Object[]{Transaction.getname(),Transaction.getprice()});
		}
		
		panel.add(scrollPane);
	}
	
	
	
	public void  actionPerformed(ActionEvent e){
		if(backBtn == e.getSource()){
			hp.setVisible(true);
			this.dispose();
		}
		
	}
}