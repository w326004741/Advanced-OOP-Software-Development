package ie.gmit.computing;

import java.util.*;
public class TypeB {
	private Date date;

	public TypeB() {
		super();
	}

	public TypeB(Date date) {
		this();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	protected void finalize() throws Throwable {
		System.out.println(this + ", an instance of TypeB ready for GC");
	}
}
