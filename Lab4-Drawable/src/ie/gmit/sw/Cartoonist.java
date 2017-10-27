package ie.gmit.sw;

public class Cartoonist extends AbstractArtist {

	@Override
	public void paint() { // Each concrete method is void
		System.out.println(this.getClass().getName() + "paint()");
		// and should output the class and method name.
	}

	// @Override
	// public void study() {
	//
	// // New stuff
	// super.study();
	// }

}
