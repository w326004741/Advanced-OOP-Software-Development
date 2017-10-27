package ie.gmit.sw;

// 第一步
import java.util.*;

public class InheritStack<E> extends ArrayList<E> implements Stackator<E> {

	private static final long serialVersionUID = 777L;

	public E peek() {
		return get(size() - 1);
	}

	public E pop() {
		E element = peek();
		remove(size() - 1);
		return element;
	}

	public void push(E element) {
		add(element);
	}

}
