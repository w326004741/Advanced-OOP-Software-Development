package ie.gmit.sw;

//第二步
import java.util.*;
							//Refactor-Extract Interface, name is Stackator and select All.
public class CompStack<E> implements Stackator<E> {
	private List<E> list = null;

	public CompStack() {
		double random = Math.random();
		if (random > 0.7d) {
			list = new Vector<E>();
		} else if (random > 0.35d) {
			list = new LinkedList<E>();
		} else {
			list = new ArrayList<E>();
		}
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Stackator#peek()
	 */
	@Override
	public E peek() {
		return list.get(list.size() - 1);
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Stackator#pop()
	 */
	@Override
	public E pop() {
		E element = peek();
		list.remove(list.size() - 1);
		return element;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Stackator#push(E)
	 */
	@Override
	public void push(E element) {
		list.add(element); // delegated
	}

	// Source.Generate Delegate Method
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Stackator#size()
	 */
	@Override
	public int size() {
		return list.size();
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Stackator#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
