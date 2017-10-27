package ie.gmit.computing;

import java.util.*;

public class TypeA {

	public static void main(String[] args) {
		// System.runFinalizersOnExit(true);//Force GC will execute finalisers.

		TypeC tc = new TypeC(new Date()); // A dependency 
										  //create an instance of TypeC 
		for (int i = 0; i < 100; i++) {   //add 方法
			tc.add(new TypeD("G" + i));
		}

		System.out.println("Count: " + tc.count());

		TypeD td = new TypeD("G50");           //delete 方法
		boolean result = tc.remove(td); // Proves that full encapsulation works.
										// 证明完全封装工作。

		System.out.println("Remove returned " + result + ". There are " + tc.count() + " elements in container.");

		List<TypeD> tds = tc.elements(); // The List returned by elements() is a
			// List<> 方法				 // copy containing clones
										// 由element（）返回的列表是包含克隆的副本
		tds.clear(); // Clears the copy and the clones, but leaves the integrity
						// of TypeC intact
						// 清除拷贝和克隆，但是保持TypeC的完整性

		System.out.println("Count: " + tc.count()); // Proof: there are still 99
													// elements in TypeC
													// 证明：TypeC还有99个元素

	}
}
