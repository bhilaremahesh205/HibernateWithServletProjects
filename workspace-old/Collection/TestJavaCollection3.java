import java.util.ArrayList;

public class TestJavaCollection3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<String> al=new ArrayList<String>();
		
		al.add("Mahesh");
		al.add("Rohan");
		al.add("Raj");
		al.add("Mohan");
		
		Iterable itr=new Iterable();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
			
		}
		
	}

}
