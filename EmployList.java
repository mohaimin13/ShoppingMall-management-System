package EntityList;
import Entity.Employ;
import java.util.ArrayList;
public class EmployList{
	private ArrayList<Employ> employs = new ArrayList<Employ>();
	public void insert(Employ c){
		 employs.add(c);
	}
	public boolean removeByID(int id){
		for(int i=0;i<employs.size();i++){
			if(employs.get(i).getID() == id){
				employs.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Employ getByID(int id){
		for(int i=0;i<employs.size();i++){
			if(employs.get(i).getID() == id){
				return employs.get(i);
			}
		}
		return null;
	}
	public ArrayList<Employ> getAll(){
		return employs;
	}
}