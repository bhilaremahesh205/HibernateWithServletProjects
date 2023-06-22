package Demo;
import java.util.*;
public class TestJavaCollection2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> al=new ArrayList<String>();  
		al.add(mahesh);
		al.add(Rohan);
		al.add(Shubham);
		
		Iterator<String> itr=al.iterator();  
		
	while(itr.hasNext()){
			System.out.println(itr.next());	
		}	

	}

}
