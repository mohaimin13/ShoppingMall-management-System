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

public class EmployManager extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel idLabel,nameLabel,salaryLabel,ageLabel,joiningdateLabel,genderLabel;
	JTextField idField,nameField,salaryField,ageField,joiningdateField,genderField;
	JButton addBtn,backBtn,updateBtn,deleteBtn;
	JTable table;
	DefaultTableModel model;
	
	Font font = new Font("arial",Font.BOLD,25);
	
	Homepage hp;
	EmployList employs;
	
	
	public EmployManager(Homepage hp, EmployList employs){
		super("Employ Management");
		this.hp = hp;
		this.employs = employs;
		initialization();
		
		//=================//
			idLabel = new JLabel("ID");
			idLabel.setFont(font);
			idLabel.setForeground(Color.WHITE);;
			idLabel.setBounds(50,20,100,30);
			panel.add(idLabel);
			
			idField = new JTextField();
			idField.setFont(font);
			idField.setBounds(130,20,200,30);
			panel.add(idField);
			
		//======================//
		//=================//
			nameLabel = new JLabel("Name");
			nameLabel.setFont(font);
			nameLabel.setForeground(Color.WHITE);
			nameLabel.setBounds(50,70,100,30);
			panel.add(nameLabel );
			
			nameField = new JTextField();
			nameField.setFont(font);
			nameField.setBounds(130,70,200,30);
			panel.add(nameField);
			
		//======================//
		//=================//
			salaryLabel = new JLabel("Salary");
			salaryLabel.setFont(font);
			salaryLabel.setForeground(Color.WHITE);
			salaryLabel.setBounds(50,120,100,30);
			panel.add(salaryLabel );
			
			salaryField = new JTextField();
			salaryField.setFont(font);
			salaryField.setBounds(130,120,200,30);
			panel.add(salaryField);
			
		//======================//
		//======================//
		//=================//
			ageLabel = new JLabel("Age");
			ageLabel.setFont(font);
			ageLabel.setForeground(Color.WHITE);;
			ageLabel.setBounds(350,20,100,30);
			panel.add(ageLabel );
			
			ageField = new JTextField();
			ageField.setFont(font);
			ageField.setBounds(490,20,200,30);
			panel.add(ageField);
			
			//=================//
			joiningdateLabel = new JLabel("Join Date");
			joiningdateLabel.setFont(font);
			joiningdateLabel.setForeground(Color.WHITE);;
			joiningdateLabel.setBounds(350,120,150,30);
			panel.add(joiningdateLabel );
			
			joiningdateField = new JTextField();
			joiningdateField.setFont(font);
			joiningdateField.setBounds(490,120,200,30);
			panel.add(joiningdateField);
			
			//=================//
			genderLabel = new JLabel("Gender");
			genderLabel.setFont(font);
			genderLabel.setForeground(Color.WHITE);;
			genderLabel.setBounds(350,70,100,30);
			panel.add(genderLabel );
			
			genderField = new JTextField();
			genderField.setFont(font);
			genderField.setBounds(490,70,200,30);
			panel.add(genderField);
			
		//======================//
		ImageIcon addimg = new ImageIcon("./RES/add.png");
		addBtn = new JButton("",addimg);
		addBtn.setBounds(20,160,200,30);
		addBtn.setFont(font);
		addBtn.addActionListener(this);
		
		
		
		panel.add(addBtn);
		
		
		
		ImageIcon deleteimg = new ImageIcon("./RES/delete.png");
		deleteBtn = new JButton("",deleteimg);
		deleteBtn.setBounds(230,160,200,30);
		deleteBtn.setFont(font);
		
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		
		ImageIcon updateimg = new ImageIcon("./RES/update.png");
		updateBtn = new JButton("",updateimg);
		updateBtn.setBounds(440,160,200,30);
		updateBtn.setFont(font);
		
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		
		
		
		
		backBtn = new JButton("<-Back");
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
		model.addColumn("Age");
		model.addColumn("Gender");
		model.addColumn("Join Date");
		model.addColumn("Salary");
		
		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setBounds(0, 0, 600, 300);
		table.setRowHeight(30);
		table.setBackground(new Color(64,128,128));
		table.setSelectionBackground(new Color(0, 0,255));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,220,600,300);
		
		ArrayList<Employ> allemploys = employs.getAll();
		
		for(int i=0;i<allemploys.size();i++){
			Employ employ = allemploys.get(i);
			model.addRow(new Object[]{employ.getID(),employ.getname(),employ.getage(),employ.getgender(),employ.getjoiningDate(),employ.getsalary()});
		}
		
		panel.add(scrollPane);
	}
	
	public void updateFile(){
		int rows = model.getRowCount();
		String allLines = "";
		for(int i=0;i<rows;i++){
			String id = table.getModel().getValueAt(i,0).toString();
			String name = table.getModel().getValueAt(i,1).toString();
			String age = table.getModel().getValueAt(i,2).toString();
			String gender = table.getModel().getValueAt(i,3).toString();
			String joiningDate = table.getModel().getValueAt(i,4).toString();
			String salary = table.getModel().getValueAt(i,5).toString();
			
			String line = "";
			if(i<rows-1){
				line = id+";"+name+";"+age+";"+gender+";"+joiningDate+";"+salary+"\n";
			}
			else{
				line = id+";"+name+";"+age+";"+gender+";"+joiningDate+";"+salary;
			}
			allLines += line;
		}
		FileIO.writeInEmploysFile(allLines,"./File/employ.txt",false);
	}
	
	public void  actionPerformed(ActionEvent e){
		if(addBtn == e.getSource()){
			if(!idField.getText().isEmpty() && 
			   !nameField.getText().isEmpty() && 
			   !ageField.getText().isEmpty() &&
			   !genderField.getText().isEmpty() &&
			   !joiningdateField.getText().isEmpty() &&
			   !salaryField.getText().isEmpty() ){
			
			model.addRow(new Object[]{idField.getText(),nameField.getText(),ageField.getText(),genderField.getText(),joiningdateField.getText(),salaryField.getText()});
			
			int id = Integer.parseInt( idField.getText());
			String name = nameField.getText();
			int age = Integer.parseInt( ageField.getText());
			String gender = genderField.getText();
			String joiningDate = joiningdateField.getText();
			double salary = Double.parseDouble( salaryField.getText());
			
			
		    
			Employ c = new Employ(id,name,age,gender,joiningDate,salary);	
			employs.insert(c);
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter All Details", "Warning",JOptionPane.WARNING_MESSAGE );
			}
		}
		else if(deleteBtn == e.getSource()){
			int rows[] = table.getSelectedRows();
			if(rows != null){
				Arrays.sort(rows);
				for(int i=rows.length-1;i>=0;i--){
					
					employs.removeByID(Integer.parseInt(table.getModel().
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