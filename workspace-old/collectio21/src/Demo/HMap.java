package Demo;
import java.util.*;
public class HMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,String> map=new HashMap<Integer,String>();
		map.put(1,"A");
		map.put(2, "B");
		map.put(3,"C");
		map.put(4,"D");
		map.put(5,"E");
		
		System.out.println("Alphabets"+map);
		
		map.remove(4);
		map.remove(2);
		
		System.out.println("Alphabets are"+map);
		map.put(2, "F");
		System.out.println("alphabets"+map);
	}

}
