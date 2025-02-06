package Entity;
public class Transaction{
	
	private String name;
	private double price;
	
	
	public Transaction(String name,double price){
		
	     this.name = name;
		
		 this.price = price;
	}
	
	public void setname(String name){this.name = name;}
	public String getname(){return this.name;}
	public void setprice(double price){this.price = price;}
	public double getprice(){return this.price;}
	
	
	
}