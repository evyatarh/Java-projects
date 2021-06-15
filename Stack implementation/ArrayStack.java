
public class ArrayStack <AnyType> implements Stack<AnyType> // Array based stack class
{ // Data members
private int top; // Top Of Stack: Index for the top element
 private AnyType [ ] element; // Array containing stack elements
 // Constructors and helper method setup 
public ArrayStack( ) {

setup(DEF_MAX_STACK_SIZE);
} // Constructor: default size
public ArrayStack(int size) {
	setup(size);
}// Constructor: specific size
// Class methods
private void setup(int size)  // Called by constructors only
{
	top=-1;
	element = (AnyType [ ]) new Object[size];
}
//----- Insert method implementations for the interface Stack here -----//
//Push newElement onto stack
public void push(AnyType newElement){
	element[++top]=newElement;
}

//Pop Element from top of stack
public AnyType pop()throws Exception{
	if(isEmpty())throw new Exception("The array Stack is empty");
	return element[top--];
}

//Remove all elements from stack
public void clear(){top=-1;}

//Return true if stack is empty
public boolean isEmpty(){return top==-1;}

//Return true if stack is full
public boolean isFull(){ return top==element.length;}

//Outputs the elements in the stack
public void showStructure (){
	for(AnyType elem: element){
		if(elem==null)return;
		System.out.print(elem + " ");
	}
}

} // interface Stack
// class ArrayStack 