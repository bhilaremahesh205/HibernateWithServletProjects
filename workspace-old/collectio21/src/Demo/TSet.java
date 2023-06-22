package Demo;
import java.util.*;
public class TSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<String> ts=new TreeSet<String>();
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("A");
		ts.add("B");
		Iterator<String> itr=ts.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}

}
