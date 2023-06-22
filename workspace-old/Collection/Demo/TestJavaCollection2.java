import java.util.LinkedList;

public class TestJavaCollection2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		LinkedList<String> li=new LinkedList<String>();
		li.add("Mahesh");
		li.add("Rohan");
		li.add("Mohan");
		li.add("Soham");
		
		Iterable ltr=new Iterable();
		while(ltr.hasNext()){
			
		System.out.println(ltr.next());
		}
		

	}

}
