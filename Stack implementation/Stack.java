

public interface Stack<AnyType> {
	// Default maximum stack size
	public static final int DEF_MAX_STACK_SIZE = 10;
	// Stack manipulation operations
	public void push(AnyType newElement); // Push newElement onto stack
	public AnyType pop()throws Exception; // Pop Element from top of stack
	public void clear(); // Remove all elements from stack
	// Stack status operations
	public boolean isEmpty(); // Return true if stack is empty
	public boolean isFull(); // Return true if stack is full
	public void showStructure (); // Outputs the elements in the stack
	} // interface Stack