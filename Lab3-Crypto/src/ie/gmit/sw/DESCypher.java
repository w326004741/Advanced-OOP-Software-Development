package ie.gmit.sw;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class DESCypher extends AbstractCypher {
	private Key key = null;

	public DESCypher() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56); // init(128) -> init(56) 否则会报错
		key = keyGen.generateKey();
		Cipher cypher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		super.setCypher(cypher);
	}

	@Override
	public byte[] encrypt(byte[] plainText) throws Throwable {
		return super.encrypt(plainText, key);
	}

	@Override
	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return super.decrypt(cypherText, key);
	}

}
