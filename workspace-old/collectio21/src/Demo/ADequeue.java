package Demo;
import java.util.*;
public class ADequeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deque<String> queue=new ArrayDeque<String>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		
	for(String str:queue){
		System.out.println(str);
	}
		
	}

}
