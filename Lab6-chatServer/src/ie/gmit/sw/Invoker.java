package ie.gmit.sw;

import java.io.*;
import java.net.*;

//The invoker holds a command object and calls the execute method
public class Invoker implements Runnable{ 
	private Socket sock = null;
	
	public Invoker(Socket s){
		this.sock = s;
	}
	
	public void run(){
		try{
			//Deserialize the socket input stream into a MessageCommand
			InputStream inputStream = sock.getInputStream();
			ObjectInputStream oin = new ObjectInputStream(inputStream);
			MessageCommand command = (MessageCommand) oin.readObject();
			
			/* Assign a receiver to the command object and call execute()
			 * By encapsulating the request in a command object, we
			 * dispense with the need to have IF/instanceof statements here.
			 * The command approach encapsulates the change that an 
			 * invoker would otherwise have to deal with. 
			 */
			command.setReceiver(MessageBoard.getInstance()); //Set the receiver. This should be done by the client, but not in client-server mode
			command.execute(); //Execute the command method. Note that the invoker does not know what this does...
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}