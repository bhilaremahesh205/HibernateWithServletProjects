package Demo;
import java.util.*;
public class Vclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<String> v=new Vector<String>();
		
	v.add("A");
	v.add("A");
	v.add("A");
	v.add("A");
	
	Iterator<String> itr=v.iterator();
	while(itr.hasNext()){
		System.out.println(itr.next());
	}
		
	}

}
