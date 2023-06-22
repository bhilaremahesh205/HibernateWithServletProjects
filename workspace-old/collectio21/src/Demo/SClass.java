package Demo;
import java.util.*;
public class SClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s=new Stack<String>();
		
		s.push("A");
		s.push("B");
		s.push("C");
		s.push("D");
		s.pop();
		s.pop();
		Iterator<String> itr=s.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			
		}
	}

}
