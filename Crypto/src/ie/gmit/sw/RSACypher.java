package ie.gmit.sw;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

//public key --- encrypting
//private key ---  keep secret

public class RSACypher extends AbstractCypher {
	private KeyPair keyRing;

	// superclass-source
	public RSACypher() throws Exception {
		// #region copy PDF
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		keyRing = keyGen.generateKeyPair();
		setCypher(Cipher.getInstance("RSA/ECB/PKCS1Padding"));
		// #end region
	}

	// override -source
	protected void finalize() throws Throwable {
		System.out.println(this.getClass().getName() + "=" + this);

	}

	@Override
	public byte[] encrypt(byte[] plainText) throws Throwable {
		return super.encrypt(plainText, keyRing.getPublic());
	}

	@Override
	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return super.decrypt(cypherText, keyRing.getPublic());
	}

}
