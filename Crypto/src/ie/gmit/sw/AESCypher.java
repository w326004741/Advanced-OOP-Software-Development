package ie.gmit.sw;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class AESCypher extends AbstractCypher {
	private Key key = null;

	public AESCypher() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(56);
		key = keyGen.generateKey();
		Cipher cypher = Cipher.getInstance("AES/ECB/PKCS5Padding");
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
