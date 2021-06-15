



public class DList <AnyType> {

	private DListNode<AnyType>  head; // Reference to the beginning of the list
	private DListNode<AnyType>  cursor;
	private DListNode<AnyType>  tail; 
	
	public DList() {
		head = new DListNode<AnyType>(null,null,null);
		tail = new DListNode<AnyType>(null,null,head);
	
		head.setNext(tail);
		cursor = head;
	}

	public void insert ( AnyType newElement ){

		if(notNull(newElement)){
		DListNode<AnyType> newNode = new DListNode<AnyType>(newElement,tail,cursor.getPrev());
		if(cursor.getPrev()!=null)gotoPrior();
		cursor.setNext(newNode);
		tail.setPrev(newNode);
		cursor = newNode;
		}
		
	}

	void remove ( ){ 
		
		if(!isEmpty()){
			DListNode<AnyType>  cursorTemp = cursor.getPrev();
			if(cursorTemp == null){
				head.setNext(cursor.getNext());
				cursor.getNext().setPrev(head);
			}
			else{
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursorTemp);
			}
			cursor = cursor.getNext();
		}
		
	}
	

	public void replace ( AnyType newElement ){
		
		if(notNull(newElement) && !isEmpty())
			cursor.setElement(newElement);
	
	}
		
		
		public boolean notNull(AnyType newElement){
			return newElement!=null; 
		}
	public void clear ( ){
		head.setNext(tail);
		tail.setPrev(head);
		cursor=head;
	}
	
	public boolean isEmpty ( ){ 
		return (cursor== head);
	}
	
	public boolean gotoBeginning ( ){
		if(!isEmpty()){
			cursor= head.getNext();
			return true;
		}
		return false;
	}
	
	
	public boolean gotoEnd ( ){
		if(!isEmpty()){
			cursor= tail.getPrev();
			return true;
		}
		return false;
	}
	

	public boolean gotoNext ( ){ 
		if(!isEmpty() && cursor!=tail){
			cursor=cursor.getNext();
			return true;
		}
		return false;
	}
	public boolean gotoPrior ( ){
		if( ! isEmpty() && cursor!=head){
			cursor=cursor.getPrev();
			return true;
		}
		return false;
}
	public AnyType getCursor ( ){
		if(!isEmpty())
			return cursor.getElement();
		return null;
	}
	public DListNode<AnyType> getcur ( ){
			return cursor;
	}
				
	public void showStructure ( ){
		if(!gotoBeginning()){ //this func is also checking if the list is empty
			System.out.println("Emapty List");
			return;
			}
		System.out.println(cursor.getElement());
		while(gotoNext()&&cursor.getNext()!=null){
			System.out.println(cursor.getElement());
			
		}
	}
	
}
