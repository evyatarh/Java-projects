//Facilitator class for the LinkedList class
public class SListNode<AnyType> { // A singly linked list node
	// Data members
	private AnyType element; // List element
	private SListNode<AnyType> next; // Reference to the next element
	// Constructor
	public SListNode(AnyType elem, SListNode<AnyType> nextPtr) {
		element = elem;
		next=nextPtr;
	}
	// Class Methods used by client class
	// Return reference to next element
	public SListNode<AnyType> getNext() {
		if(next==null)
			return null;
		return next;
	}
	// Set reference to next element & return that reference
	public void setNext (SListNode<AnyType> nextVal) {
		next=nextVal;
	}
	// Return the element in the current node
	public AnyType getElement() { 
		return element;
	}
	// Set current element to newElem
	public void setElement(AnyType newElem) {
		element = newElem;
	}
} // class LinkedListNode
