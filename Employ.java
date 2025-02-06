package Entity;
public class Employ{
	private int id;
	private String name;
	private double salary;
	private int age;
	private String joiningDate;
	private String gender;
	
	
	
	public Employ(int id,String name,int age,String gender, String joiningDate,double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.joiningDate = joiningDate;
		this.gender = gender;
	}
	public void setID(int id){this.id = id;}
	public int getID(){return id;}
	
	public void setname(String name){this.name = name;}
	public String getname(){return this.name;}
	
	public void setsalary(double salary){this.salary = salary;}
	public double getsalary(){return this.salary;}
	
	public void setjoiningDate(String joiningDate){this.joiningDate = joiningDate;}
	public String getjoiningDate(){return this.joiningDate;}
	
	public void setgender(String gender){this.gender = gender;}
	public String getgender(){return this.gender;}
	
	public void setage(int age){this.age = age;}
	public int getage(){return this.age;}
	
	
}