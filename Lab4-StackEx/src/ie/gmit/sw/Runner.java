package ie.gmit.sw;

import java.util.*;

public class Runner {

	public static void main(String[] args) {
		Stackator<String> is = new CompStack<String>();
		for (int i = 0; i < 100; i++) {
			is.push("Element-" + i);
		}

		while (!is.isEmpty()) {
			System.out.println(is.pop());
		}

		ArrayList<String> ar = (ArrayList<String>) is;
	}

}
