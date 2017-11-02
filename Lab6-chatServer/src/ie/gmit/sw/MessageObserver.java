package ie.gmit.sw;

import java.io.*;

/* MessageObserver and MessageRequest objects are encapsulated in the 
 * Command object. It is the function of the receiver to know what to
 * do with a request containing a MessageObserver. In this case, such
 * requests result in the MessageObserver been added to the receivers
 * list of observers and will result in the MessageObserver being 
 * notified when a change occurs. Note: all implementations of this 
 * interface are serializable.
 */
public interface MessageObserver extends Serializable{
	public String getHost();
	public int getPort();
}
