package Demo;
import java.util.*;
public class LinkedList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> ll=new LinkedList<String>();
		
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		ll.add("A");
		ll.add("B");
		
		Iterator<String> itr=ll.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}

}
