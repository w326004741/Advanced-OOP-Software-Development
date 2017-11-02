package ie.gmit.computing;

import java.util.*;
public class TypeA {

	public static void main(String[] args) {
		//System.runFinalizersOnExit(true);//Force GC will execute finalisers.
		
		TypeC tc = new TypeC(new Date()); //A dependency
		
		for (int i = 0; i < 100; i ++){
			tc.add(new TypeD("G" + i));
		}
		
		System.out.println("Count: " + tc.count());
		
		TypeD td = new TypeD("G50");
		boolean result = tc.remove(td); //Proves that full encapsulation works.
		
		System.out.println("Remove returned " + result + ". There are " + tc.count() + " elements in container.");
		
		List<TypeD> tds = tc.elements(); //The List returned by elements() is a copy containing clones
		tds.clear(); //Clears the copy and the clones, but leaves the integrity of TypeC intact

		
		System.out.println("Count: " + tc.count()); //Proof: there are still 99 elements in TypeC
		
	}
}
