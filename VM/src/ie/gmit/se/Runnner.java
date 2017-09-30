package ie.gmit.se;

import java.io.IOException;
import java.util.*;

public class Runnner {

	public static void main(String[] args) throws Throwable {
		List<Person> people = new ArrayList<>();
		
		int num = System.in.read();
		
		Person p = null;
		
		for (int i = 0; i < 100000000; i++){
		
			p = new Person(i);
			if (i % 100 == 0) people.add(p);
			
			
		}
		
		
	}
}
