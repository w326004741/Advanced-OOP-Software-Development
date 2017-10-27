package ie.gmit.sw;

public class CypherFactory {

	// Singleton Step 2: Create a static instance
	// An eager Singleton.
	// private static CypherFactory cf = new CypherFactory();

	// Can do a lazy one tool
	private static CypherFactory cf = null;

	// Singleton Step 1: private constructor
	private CypherFactory() {

	}

	// Singleton Step 3:
	public static CypherFactory getInstance() {
		if (cf == null)
			cf = new CypherFactory();
		return cf;

	}

	public Cypher newCypher(CypherType type) throws Exception {
		if (type == CypherType.ASymmetric) {
			return new RSACypher();
		} else {
			return new DESCypher();
		}
	}
}
