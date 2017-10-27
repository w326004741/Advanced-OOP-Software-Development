package ie.gmit.sw;

public interface Stackator<E> {

	E peek(); // Return most recently inserted element

	E pop(); // Return and remove most recently inserted element

	void push(E element); // Return the number of elements in the stack

	// Source.Generate Delegate Method
	int size();

	boolean isEmpty();// Return true if the stack is empty

	void clear();// Remove all elements

}