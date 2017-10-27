package ie.gmit.computing;

import java.util.*;
public class TypeC {
	private Date date; // 1: + TypeC(Date)--> Generate Constructor using Field
	private List<TypeD> list = new ArrayList<TypeD>(); //The list and everything on it should be completely encapsulated
													   //列表和其上的一切都应该被完全封装
	//Source-Generate Constructor using Field-choose date
	public TypeC(Date date) {
		super();
		this.date = date; //Date is a bit of a red herring...
	}
	// 2: add(TypeD):void 的方法－ TypeD implement Cloneable 这个基类
	public boolean add(TypeD element) {
		try {
			TypeD td = (TypeD) element.clone();
			return list.add(td);
		} catch (CloneNotSupportedException e) {
			return false;
		}
	}
	
	// 3: + delete(TypeD): void
	public boolean remove(TypeD element) {
		return list.remove(element); //Only works because equals(), used by contains() in ArrayList, is over-ridden in TypeD.
	}								//只有在ArrayList中由equals（）使用的equals（）作用在TypeD中才会被覆盖。
	// 4: + count(): int
	public int count() {
		return list.size();
	}
	
	// 5: + contains(TypeD):boolean
		public boolean contains(TypeD element) {
			return list.contains(element); //Only works because equals(), used by contains() in ArrayList, is over-ridden in TypeD.
			//只有在ArrayList中由equals（）使用的equals（）作用在TypeD中才会被覆盖。
		}
	
	// 6: element(): List<TypeD>
	public List<TypeD> elements(){ //Note: both the List and TypeD object have a "black diamond" relationship with TypeC
								   //注意：List和TypeD对象都与TypeC具有“黑钻石”关系(Composition组合关系)
		List<TypeD> temp = new ArrayList<TypeD>(); //Require a new List with new elements to preserve encapsulation
		for (TypeD element: list){ //for(元素类型 元素变量 ：集合变量)
			try {
				TypeD td = (TypeD) element.clone(); //Also need to clone() each element to preserve encapsulation
				temp.add(td);						//还需要clone()每个元素来保护封装
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
