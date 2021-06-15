
public class DListNode<AnyType> { // A doubled linked list node
	// Data members
	private AnyType element; // List element
	private DListNode<AnyType> next; // Reference to the next element
	private DListNode<AnyType> prev; // Reference to the previous element
	// Constructor
	public DListNode(AnyType elem, DListNode<AnyType> nextPtr,DListNode<AnyType> prevPtr) { 
		element = elem;
		next = nextPtr;
		prev = prevPtr;
	}
	// Return reference to next element
	public DListNode<AnyType> getNext() { return next; }
	// Set reference to next element & return that reference
	public void setNext (DListNode<AnyType> nextVal) { next = nextVal; }
	// Return reference to previous element
	public DListNode<AnyType> getPrev() {return prev; }
	// Set reference to previous element & return that reference
	public void setPrev (DListNode<AnyType> PrevVal) { prev = PrevVal;}
	// Return the element in the current node
	public AnyType getElement() {return element; }
	// Set current element to newElem
	public void setElement(AnyType newElem) { element = newElem; }
	

}
