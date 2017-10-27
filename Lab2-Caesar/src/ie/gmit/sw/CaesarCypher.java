package ie.gmit.sw;

public class CaesarCypher extends AbstractCypher {

	public CaesarCypher(int key) throws CypherException {
		super.setKey(new CypherKeyImpl(key));
	}

	public CaesarCypher(CypherKey key) throws CypherException {
		super.setKey(key);
	}

	protected byte[] doCypher(byte[] bytes, boolean encrypt) throws CypherException {
		byte[] temp = new byte[bytes.length];
		byte offset = Byte.parseByte(getKey());

		for (int i = 0; i < bytes.length; i++) {
			//There is a pretty bad bug here... Can you see what it might be?
			if (encrypt) {
				temp[i] = (byte) (bytes[i] + offset);
			} else {
				temp[i] = (byte) (bytes[i] - offset);
			}
		}
		return temp;
	}

	protected void finalize() throws Throwable {
		// finalize方法是与Java编程中的垃圾回收器有关系。即：当一个对象变成一个垃圾对象的时候，如果此对象的内存被回收，那么就可以调用系统中定义的finalize方法来完成
		// finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的
		super.finalize();
	}

	private class CypherKeyImpl implements CypherKey {
		private int key;

		public CypherKeyImpl(int key) {
			this.key = key;
		}

		public void setKey(String key) throws CypherException {
			this.key = Integer.parseInt(key);
		}

		public String getKey() {
			return new Integer(this.key).toString();
		}

	}

	public void setKey(String key) throws CypherException {
		super.setKey(new CypherKeyImpl(Integer.parseInt(key)));
	}
}
