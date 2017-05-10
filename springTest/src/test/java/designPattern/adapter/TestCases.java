package designPattern.adapter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCases {
	
	@Test
	public void adapterTest(){
		Bird b1 = new YellowBird();
		Bird b2 = new YellowBird();
		
		Duck d1 = new YellowDuck();
		Bird b3 = new DuckToBirdAdapter(d1);
		
		List<Bird> birds = new ArrayList<Bird>();
		birds.add(b1);
		birds.add(b2);
		birds.add(b3);
		
		for(Bird b:birds){
			b.show();
			System.out.println();
		}
		
		
	}

}
