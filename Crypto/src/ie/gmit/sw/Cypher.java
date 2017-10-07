package ie.gmit.sw;

import java.security.Key;

public interface Cypher {

	public byte[] encrypt(byte[] plainText, Key key) throws Throwable;
	public byte[] decrypt(byte[] cypherText, Key key) throws Throwable;

	public byte[] encrypt(byte[] plainText) throws Throwable;
	public byte[] decrypt(byte[] cypherText) throws Throwable;
}
