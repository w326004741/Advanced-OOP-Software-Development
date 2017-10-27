package ie.gmit.sw;

public abstract class AbstractArtist implements Paintable {

	public void draw() {
		System.out.println(this.getClass().getName() + "draw()");
		paint();
	}

	public void mixColours() {
		System.out.println(this.getClass().getName() + "mixColours()");
	}

	public void study() {
		System.out.println(this.getClass().getName() + "study()");
		paint();
	}

	public abstract void paint();
}
