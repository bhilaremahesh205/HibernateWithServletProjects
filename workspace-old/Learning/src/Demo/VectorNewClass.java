package Demo;
import java.util.*;
public class VectorNewClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
			Vector<String> v=new Vector<String>();  
			v.add("Ayush");  
			v.add("Amit");  
			v.add("Ashish");  
			v.add("Garima");  
			Iterator<String> itr=v.iterator();  
			while(itr.hasNext()){  
			System.out.println(itr.next());  
			}  
			}  
			}  