package ie.gmit.sw;

import java.io.*;
import java.net.*;
import java.util.*;

// As a receiver, MessageBoard knows how to perform the action needed to carry out a request. 
public class MessageBoard implements Receiver{
	//A singleton instance of the class
	private static MessageBoard mb = new MessageBoard();
	
	//This is a generic list of MessageObserver objects/
	private List<MessageObserver> observers = new ArrayList<MessageObserver>();

	private MessageBoard(){ //The Highlander Principle - "There can be only one". BTW - this is only a known principle among my students...
	}
	
	public static MessageBoard getInstance(){
		return mb;
	}
	
	
	//Dispatch the new MessageRequest to each observer in our list
	public void update(MessageRequest request){
		for (MessageObserver observer: observers){
			dispatch(observer, request);
		}
	}
	
	//Add a new observer to our list
	public void add(MessageObserver observer){
		observers.add(observer);
	}
	
	//open a socket back to a client and send it the new MessageRequest 	 
	private void dispatch(MessageObserver observer, MessageRequest request){
		try{
			Socket s = new Socket(observer.getHost(), observer.getPort());
    		OutputStream outStream = s.getOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(request);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}