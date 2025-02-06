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

public class ProductManager extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel idLabel,modelLabel,rentLabel,unitsLabel;
	JTextField idField,modelField,rentField,unitsField;
	JButton addBtn,backBtn,updateBtn,deleteBtn;
	JTable table;
	DefaultTableModel model;
	
	Font font = new Font("arial",Font.BOLD,25);
	
	Homepage hp;
	ProductList products;
	
	
	public ProductManager(Homepage hp, ProductList products){
		super("Product Management");
		this.hp = hp;
		this.products = products;
		initialization();
		
		//=================//
			idLabel = new JLabel("ID");
			idLabel.setFont(font);
			idLabel.setForeground(Color.WHITE);
			idLabel.setBounds(50,20,100,30);
			panel.add(idLabel);
			
			idField = new JTextField();
			idField.setFont(font);
			idField.setBounds(130,20,200,30);
			panel.add(idField);
			
		//======================//
		//=================//
			modelLabel = new JLabel("Name");
			modelLabel.setFont(font);
			modelLabel.setForeground(Color.WHITE);
			modelLabel.setBounds(50,70,100,30);
			panel.add(modelLabel );
			
			modelField = new JTextField();
			modelField.setFont(font);
			modelField.setBounds(130,70,200,30);
			panel.add(modelField);
			
		//======================//
		//=================//
			rentLabel = new JLabel("Price");
			rentLabel.setFont(font);
			rentLabel.setForeground(Color.WHITE);
			rentLabel.setBounds(50,120,100,30);
			panel.add(rentLabel );
			
			rentField = new JTextField();
			rentField.setFont(font);
			rentField.setBounds(130,120,200,30);
			panel.add(rentField);
			
		//======================//
		//======================//
		//=================//
			unitsLabel = new JLabel("UNITS");
			unitsLabel.setFont(font);
			unitsLabel.setForeground(Color.WHITE);;
			unitsLabel.setBounds(50,170,100,30);
			panel.add(unitsLabel );
			
			unitsField = new JTextField();
			unitsField.setFont(font);
			unitsField.setBounds(130,170,200,30);
			panel.add(unitsField);
			
		//======================//
		ImageIcon addimg = new ImageIcon("./RES/add.png");
		addBtn = new JButton("",addimg);
		addBtn.setBounds(350,20,200,30);
		addBtn.setFont(font);
		addBtn.addActionListener(this);
		
		
		
		panel.add(addBtn);
		
		
		
		ImageIcon deleteimg = new ImageIcon("./RES/delete.png");
		deleteBtn = new JButton("",deleteimg);
		deleteBtn.setBounds(350,70,200,30);
		deleteBtn.setFont(font);
		
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		
		ImageIcon updateimg = new ImageIcon("./RES/update.png");
		updateBtn = new JButton("",updateimg);
		updateBtn.setBounds(350,110,200,30);
		updateBtn.setFont(font);
		
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		
		
		
		
		backBtn = new JButton("Home");
		backBtn.setBounds(580,580,150,30);
		backBtn.setFont(font);
		backBtn.setBackground(Color.RED);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		createTable();
		
		this.setVisible(true);
	}
	
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,650);
		this.setLayout(null);
		this.setLocation(200,100);
		this.setIconImage(new ImageIcon("./RES/logo.png").getImage());
		
		JLabel background = new JLabel(new ImageIcon("./RES/bg.png"));
		background.setBounds(0,0,800,650);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,800,650);
		
		panel.setOpaque(false);
		
		this.add(panel);
		this.add(background);
	}
	
	public void createTable(){
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("PRICE");
		model.addColumn("UNITS");
		
		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setBounds(0, 0, 600, 300);
		table.setRowHeight(30);
		table.setBackground(new Color(64,128,128));
		table.setSelectionBackground(new Color(0, 0,255));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,220,600,300);
		
		ArrayList<Product> allproducts = products.getAll();
		
		for(int i=0;i<allproducts.size();i++){
			Product product = allproducts.get(i);
			model.addRow(new Object[]{product.getID(),product.getname(),product.getprice(),product.getunits()});
		}
		
		panel.add(scrollPane);
	}
	
	public void updateFile(){
		int rows = model.getRowCount();
		String allLines = "";
		for(int i=0;i<rows;i++){
			String id = table.getModel().getValueAt(i,0).toString();
			String name = table.getModel().getValueAt(i,1).toString();
			String price = table.getModel().getValueAt(i,2).toString();
			String units = table.getModel().getValueAt(i,3).toString();
			
			String line = "";
			if(i<rows-1){
				line = id+";"+name+";"+price+";"+units+"\n";
			}
			else{
				line = id+";"+name+";"+price+";"+units;
			}
			allLines += line;
		}
		FileIO.writeInFile(allLines,"./File/products.txt",false);
	}
	
	public void  actionPerformed(ActionEvent e){
		if(addBtn == e.getSource()){
			if(!idField.getText().isEmpty() && 
			   !modelField.getText().isEmpty() &&
				!unitsField.getText().isEmpty() && 			   
			   !rentField.getText().isEmpty() ){
			
			model.addRow(new Object[]{idField.getText(),modelField.getText(),rentField.getText(),unitsField.getText()});
			
			int id = Integer.parseInt( idField.getText());
			String productModel = modelField.getText();
			double price = Double.parseDouble( rentField.getText());
			
			
		    int units = Integer.parseInt( rentField.getText());
			Product c = new Product(id,productModel,price,units);	
			products.insert(c);
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter All Details", "Warning",JOptionPane.WARNING_MESSAGE );
			}
			updateFile();
		}
		else if(deleteBtn == e.getSource()){
			int rows[] = table.getSelectedRows();
			if(rows != null){
				Arrays.sort(rows);
				for(int i=rows.length-1;i>=0;i--){
					
					products.removeByID(Integer.parseInt(table.getModel().
													getValueAt(rows[i],0).
													toString() ));
					model.removeRow(rows[i]);
				}
				updateFile();
			}
		}
		else if(updateBtn == e.getSource() ){
			updateFile();
		}
		
		else if(backBtn == e.getSource()){
			hp.setVisible(true);
			this.dispose();
		}
		
	}
}