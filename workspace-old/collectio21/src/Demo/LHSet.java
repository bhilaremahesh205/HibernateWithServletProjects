package Demo;
import java.util.*;
public class LHSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		
		set.add("A");
		set.add("B");
		set.add("D");
		set.add("D");
		set.add("E");
		
		Iterator<String> itr=set.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}

}
