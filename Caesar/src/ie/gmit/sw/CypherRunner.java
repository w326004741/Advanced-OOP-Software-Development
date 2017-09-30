package ie.gmit.sw;

public class CypherRunner {

	public CypherRunner() throws Throwable {

		Cypherator cc = new CaesarCypher(4);

		String plain = "Happy Days!";
		System.out.println(cc.encrypt(plain));
		System.out.println(cc.decrypt(cc.encrypt(plain)));
	}

	public static void main(String[] args) throws Throwable {
		new CypherRunner();
	}

}
