package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class MessageClient{
	private String clientIP;
	private String remoteHost;
	private int remotePort;
	private static final int CLIENT_PORT = 9998;
	private ServerSocket serverSocket = null;
	private Socket incomingMessageSocket = null;
	private JTextArea text;
	private JScrollPane scroller;
	private JFrame window;
	private JTextField message;
	private MessageObserver me;
	
	public static void main(String[] args) throws Exception{
		new MessageClient("127.0.0.1", "127.0.0.1", 9999);
		/*
		if (args.length < 3){
			System.out.println("Usage java gmit.MessageClient clientIPAddress, remoteHost, remotePort");
			System.exit(0);
		}
		
		new MessageClient(args[0], args[1], Integer.parseInt(args[2]));
		*/
	}
	
	public MessageClient(String client, String host, int port) throws Exception{	
		this.clientIP = client;
		this.remoteHost = host;
		this.remotePort = port;
		
		registerObserver();
		createUI();
		
	}
	
	//Open a socket to the chat server and register as an observer
	private void registerObserver() throws Exception{
		serverSocket = new ServerSocket(CLIENT_PORT);	
		ClientListener listener = new ClientListener();
		listener.start();

		me = new MessageObserverImpl(clientIP, CLIENT_PORT);
    	try{
    		Socket s = new Socket(remoteHost, remotePort);
    		OutputStream outStream = s.getOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(outStream);
			out.writeObject(me);
    	}catch(Exception e){
    		e.printStackTrace();
    	}		
	}
	
	
	//Create a simple Swing UI for the message client.
	private void createUI(){
		window = new JFrame("Message Client");
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
		
		
		text = new JTextArea(40, 30);
		text.setBackground(Color.WHITE);
		text.setLineWrap(true);
		text.setEditable(false);
		scroller = new JScrollPane(text);
		scroller.setPreferredSize(new Dimension(380, 150));
		scroller.setMaximumSize(new Dimension(380, 150));
		scroller.setMinimumSize(new Dimension(380, 150));
		
		message = new JTextField(20);
		
		/* Calling addActionListener() tells Swing to register the ActionListener 
		 * observer (the anonomyous inner class) to be notified when btnSendMessage
		 * is clicked. The Swing event dispatch manager calls actionPerformed() when
		 * this event occurs. In this case, actionPerformed() opens a socket to
		 * the chat server and sends a serialized MessageRequest containing the
		 * new message. 
		 */
		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	try{
            		Socket s = new Socket(remoteHost, remotePort);
            		OutputStream outStream = s.getOutputStream();
					ObjectOutputStream out = new ObjectOutputStream(outStream);
					MessageRequest newMessage = new MessageRequestImpl(remoteHost);
					newMessage.setMessage(message.getText());
					out.writeObject(newMessage);
            	}catch(Exception e){
            		e.printStackTrace();
            	}
            }
        });
		
		window.setLayout(new FlowLayout());
		window.add(scroller);
		window.add(message);
		window.add(btnSendMessage);
		window.setSize(400, 250);
		window.setVisible(true);	
	}

	
	
	/* The client application needs to open a sock in order to listen for
	 * incoming message updates from the chat server. The client host name
	 * and port number and encapsulated in a MessageObserver instance
	 * that the constructor created and registers as an observer.
	 */
	class ClientListener extends Thread{
		public void run(){
			
			try{
				while(true){
					incomingMessageSocket = serverSocket.accept();
					InputStream inputStream = incomingMessageSocket.getInputStream();
					ObjectInputStream oin = new ObjectInputStream(inputStream);
					MessageRequest request = (MessageRequest) oin.readObject();
					
					updateDisplay(request);
				}		
			}catch(Exception e){
				e.printStackTrace();	
			}
		}
	}
	
	//Update the text pane with incoming message
	private void updateDisplay(MessageRequest request){
		StringBuffer buffer = new StringBuffer();
		buffer.append(text.getText());
		buffer.append("\n" + request.getName() + ">" + request.getMessage());
		text.setText(buffer.toString());
	}
}