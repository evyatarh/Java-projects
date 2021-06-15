
public class DListStack <AnyType> implements Stack<AnyType> // Array based stack class
{ // Data members
private DListNode<AnyType> top; // Top Of Stack: Reference to top of stack
DList <AnyType> listOfElementsForStackElements;
private int ListSize;
private int counter;
 // Constructors and helper method setup
//Constructor: default size
public DListStack( ) {
	setup(DEF_MAX_STACK_SIZE);
} 
//Constructor2: ignore size :for compatibility with ArrayStack
public DListStack(int size) { 
	setup(size);
} 
//Called by constructors only
private void setup(int size) {
	listOfElementsForStackElements=new DList<AnyType>();
	ListSize=size;
	counter=0;
} 
//Push newElement onto stack
public void push(AnyType newElement){
	listOfElementsForStackElements.insert(newElement);
	counter++;
}
// Pop Element from top of stack
public AnyType pop()throws Exception{
	AnyType elem=listOfElementsForStackElements.getCursor();
	listOfElementsForStackElements.remove();
	counter--;
	return elem;
}
//Remove all elements from stack
public void clear(){
	if(isEmpty()) return;
	listOfElementsForStackElements.clear();
	counter=0;
}
// Stack status operations
//Return true if stack is empty
public boolean isEmpty(){
	return listOfElementsForStackElements.isEmpty();
}
//Return true if stack is full
public boolean isFull(){
	return (counter==ListSize);
}
//Outputs the elements in the stack
public void showStructure (){
	listOfElementsForStackElements.showStructure();
}
} // class DListStack 