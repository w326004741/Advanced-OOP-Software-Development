package ie.gmit.sw;

/* This interface defines the behaviour for a receiver of a command object.
 * Note that the receiver supports both MessageObserver and MessageRequest
 * types.
 */

public interface Receiver {
	public void add(MessageObserver observer);
	public void update(MessageRequest request);
}
