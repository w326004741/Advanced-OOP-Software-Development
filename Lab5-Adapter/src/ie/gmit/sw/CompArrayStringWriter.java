package ie.gmit.sw;

public class CompArrayStringWriter implements ListWriterable {

	private SimpleStringWriter ssw = new SimpleStringWriter();

	@Override
	public void write(String[] list) {
		for (String s : list) {
			ssw.write(s);
		}
	}
// Source - Generate Delegate Method, choose open and close.
	public void open(String fileName) {
		ssw.open(fileName);
	}

	public void close() {
		ssw.close();
	}
	
	
}