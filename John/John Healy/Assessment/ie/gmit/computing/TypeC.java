package ie.gmit.computing;

import java.util.*;
public class TypeC {
	private Date date;
	private List<TypeD> list = new ArrayList<TypeD>(); //The list and everything on it should be completely encapsulated
	
	public TypeC(Date date) {
		super();
		this.date = date; //Date is a bit of a red herring...
	}

	public boolean add(TypeD element) {
		try {
			TypeD td = (TypeD) element.clone();
			return list.add(td);
		} catch (CloneNotSupportedException e) {
			return false;
		}
	}

	public boolean contains(TypeD element) {
		return list.contains(element); //Only works because equals(), used by contains() in ArrayList, is over-ridden in TypeD.
	}

	public boolean remove(TypeD element) {
		return list.remove(element); //Only works because equals(), used by contains() in ArrayList, is over-ridden in TypeD.
	}

	public int count() {
		return list.size();
	}
	
	public List<TypeD> elements(){ //Note: both the List and TypeD object have a "black diamond" relationship with TypeC
		List<TypeD> temp = new ArrayList<TypeD>(); //Require a new List with new elements to preserve encapsulation
		for (TypeD element: list){
			try {
				TypeD td = (TypeD) element.clone(); //Also need to clone() each element to preserve encapsulation
				temp.add(td);
			} catch (CloneNotSupportedException e) {
				//Ignore
			}			
		}
		
		return temp;
	}
	
	protected void finalize() throws Throwable {
		System.out.println(this + ", an instance of TypeC ready for GC");
	}
	
}
