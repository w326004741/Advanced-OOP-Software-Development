package ie.gmit.sw;

public class Client {

	public static void main(String[] args) {
		String[] names = { "John", "Paul", "Mary", "Anne", "Alan", "Barbara" };
		ListWriterable writer = new CompArrayStringWriter(); // We do not have a conforming class yet
		writer.open("people.txt");
		writer.write(names);
		writer.close();
	}

}
