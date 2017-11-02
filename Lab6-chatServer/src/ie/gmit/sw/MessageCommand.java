package ie.gmit.sw;

import java.io.*;

/* The command interface encapulates invocations from the message client
 * to the receiver. In this case, a request to the receiver (who does
 * the actual work) can be either of the following:
 * 	1)A request to be added as an observer.
 *  2)A request to propagate a message to other clients.
 * The point is that both request types are encapsulated in the 
 * command object. An invoker calls execute() and the receiver
 * does whatever execute() tells it to do - in this case add() or
 * update(). Note: all implementations of this interface are
 * serializable.
 */

public interface MessageCommand extends Serializable{
	public void setReceiver(Receiver r);
	public void execute();
}
