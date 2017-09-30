package ie.gmit.se;

public class Person {

	private int id;

	public Person(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(toString() + "about to be GC'd.");;
	}
	

	@Override
	public String toString() {
		return this  + "id= " + this.id;
	}


	
	
}
