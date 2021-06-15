import java.awt.Cursor;
import java.awt.HeadlessException;

public class SList <AnyType> // Singly linked list
{
// Data members
private SListNode<AnyType> head, // Reference to the beginning of the list
				cursor; // Reference to current cursor position
// Constructors & Helper Method
// Default constructor: Creates an empty list
public SList ( ) { 
	head = null;
	cursor=head;
}


// Class methods
void insert ( AnyType newElement ){
	if(newElement==null)
		return;
	SListNode<AnyType> newNode = new SListNode<AnyType>(newElement, null); // allocating new node
	if(isEmpty()){ // first node of the list
		head = newNode;
		cursor = head;
		return;
	}
	cursor.setNext(newNode); // updating the list
	cursor = newNode;
}



void remove ( ){
	if(isEmpty())
		return;
	SListNode<AnyType> tmp=cursor; //tmp is the node we are deleting
	if(gotoPrior()==false){ // its the head we are deleting cause the list isnt empty
		head = head.getNext();
		return;
	}
	if(tmp.getNext() == null) { // last element of the list
		cursor.setNext(null);
		gotoBeginning();
		return;
	} else
		cursor.setNext(tmp.getNext());	
}

void replace ( AnyType newElement ){ //replacing an element in the place cursor is pointing to
	if(isEmpty() || newElement == null)
		return;
	cursor.setElement(newElement);
}

/**
 * "deleting" the list
 */
void clear ( ){
	cursor = head;
	head = null;
}

boolean isEmpty ( ){
	if(head==null)
		return true;
	return false;
}


/**
 * 
 * @return false if the list is empty
 * 
 * else goes to the beginning
 */
boolean gotoBeginning ( ){
	if(isEmpty())
		return false;
	cursor=head;
	return true;
	
}


/**
 * 
 * @return false if the list is empty else it puts the cursor in the end
 */
boolean gotoEnd ( ){
	if(isEmpty())
		return false;
	SListNode<AnyType> tmpHead = head;
	while(tmpHead.getNext()!=null){
		tmpHead = tmpHead.getNext();
	}
	cursor = tmpHead;
	return true;
}


/**
 * 
 * 	if not empty, moves the cursor to the next element in the list
 */
boolean gotoNext ( ){
	if(isEmpty())
		return false;
	if(cursor.getNext()!=null){
		cursor = cursor.getNext();
		return true;
	}
	return false;
}


/**
 * 
 * 	if not empty, moves the cursor to the previous element in the list
 */

boolean gotoPrior ( ){
	if(isEmpty())
		return false;
	if(cursor != head){
		SListNode<AnyType> tmpHead = head;
		SListNode<AnyType> prior = head;
		while(tmpHead!=cursor){
			prior = tmpHead;
			tmpHead = tmpHead.getNext();
		}
		cursor = prior;
		return true;
	}
	return false;	
}


/**
 * 
 * @return the cursor's place in the list
 */
AnyType getCursor ( ){
	if(isEmpty())
		return null;
	return cursor.getElement();
}


/**
 * prints the structure
 */
void showStructure ( ){
	if(isEmpty())
		return;
	SListNode<AnyType> tmpHead = head;
	while(tmpHead!=null){
		System.out.println(tmpHead.getElement());
		tmpHead = tmpHead.getNext();
	}
}
} // class SList
