package Demo;
import java.util.*;
public class ABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<String> al=new ArrayList<String>();
	
	al.add("Mahesh");
	al.add("Rohan");
	al.add("RAM");
	al.add("Sunil");
	al.add("Mahesh");
	al.add("Rohan");
	
	Iterator<String> itr=al.iterator();
	while(itr.hasNext()){
		System.out.println(itr.next());
		
	}
	}
}
