package ie.gmit.sw;

/* MessageObserverImpl is both a concrete command object and a MessageObserver.
 * When execute() is called by the invoker, the add() method of the receiver
 * is invoked. 
 */
public class MessageObserverImpl implements MessageObserver, MessageCommand{	
	private static final long serialVersionUID = 2L;	
	private transient Receiver receiver;
	private String host;
	private int port;
	
	public void setReceiver(Receiver r){
		this.receiver = r;
	}
	
	public void execute(){
		receiver.add(this);
	}
	
	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public MessageObserverImpl(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
}
