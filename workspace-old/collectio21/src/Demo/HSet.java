package Demo;
import java.util.*;
public class HSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hset=new HashSet<String>();		
		hset.add("A");
		hset.add("B");
		hset.add("C");
		hset.add("D");
		hset.add("A");
		hset.add("C");
		System.out.println("Is arraylist empty? "+hset.isEmpty());
        //System.out.println("Index of PERL is "+hset.indexOf("D"));
        System.out.println("Size of the arraylist is: "+hset.size());
		Iterator<String> itr=hset.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	
	}

}
