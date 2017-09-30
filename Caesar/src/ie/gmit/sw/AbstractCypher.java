package ie.gmit.sw;

public abstract class AbstractCypher implements CypherKey, Cypherator {

	private CypherKey key;

	public AbstractCypher() {
		super();
	}

	public void setKey(CypherKey key) throws CypherException {
		this.key = key;
	}

	public String getKey() {
		return this.key.getKey();
	}

	public String encrypt(String plainText) throws CypherException {
		return new String(encrypt(plainText.getBytes()));
	}

	public byte[] encrypt(byte[] plainText) throws CypherException {
		return doCypher(plainText, true);
	}

	public String decrypt(String cypherText) throws CypherException {
		return new String(decrypt(cypherText.getBytes()));
	}

	public byte[] decrypt(byte[] cypherText) throws CypherException {
		return doCypher(cypherText, false);
	}

	protected abstract byte[] doCypher(byte[] bytes, boolean encryption) throws CypherException;
}