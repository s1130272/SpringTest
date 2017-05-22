package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	
	public static void main(String[] args) {
		
		
		List<String> l = new ArrayList<String>();
		 l.add("aa");
		 l.add("bb");
		 l.add("cc");
		 
		 Iterator<String> iter = l.iterator();
		 while(iter.hasNext()){
			  String str = (String)iter.next();
			  System.out.println(str);
			  iter.remove();
		 }
		 System.out.println(l.size());
	}

}
