package ie.gmit.computing;

public class TypeD implements Cloneable {
	private String name;

	public TypeD() {
		super();
	}

	public TypeD(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// 如果没有implement Cloneable接口，并在调用Object clone()方法(也就是 super.clone())
	// 则Object clone()方法就会抛出异常
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	// refer: http://www.imooc.com/qadetail/153897
	// 因为如果name==null 则返回0；那么result就是一个固定值；
	// name.hashCode()则是将name值转换为hash值，再加上前面的固定值，这样就造成了，
	// 如果name值在不被修改的情况下，return result返回的永远是一个固定值，
	// 这样就判定了是否一致；如果name值被修改，那么肯定是不一致的了~~~
	public int hashCode() {		// hashcode 方法重写
		final int prime = 31; // 定义一个固定因数,31只是一个默认的传统，当然也可以是其他的
		int result = 1; // 定义返回的变量并初始化为1
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		// 第二次重新赋值规则：固定因数 * result 再加上 （如果name == null ，则加上0；否则是name的hashCode。）
		return result;
	}

	@Override
	// 任何情况下，x.equals(null)，永远返回是“false”；x.equals(和x不同类型的对象)永远返回是“false”。
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeD other = (TypeD) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	protected void finalize() throws Throwable {
		System.out.println(this + ", an instance of TypeD ready for GC");
	}
}
