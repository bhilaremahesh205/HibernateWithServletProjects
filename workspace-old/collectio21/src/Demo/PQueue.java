package Demo;
import java.util.*;
public class PQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<String> queue=new PriorityQueue<String>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		queue.add("E");
		queue.add("F");
		System.out.println("head:"+queue.element());
		System.out.println("head:"+queue.peek());
		System.out.println("After the iteration of opeation");
		Iterator itr=queue.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		queue.remove();
		queue.poll();
		System.out.println("After the iteration");
		
		Iterator<String> itr2=queue.iterator();
		while(itr2.hasNext()){
			System.out.println(itr2.next());
		}
		
	}

}
