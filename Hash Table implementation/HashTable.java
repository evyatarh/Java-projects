import java.lang.reflect.Array;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class HashTable {

	private static final int DEF_MAX_HASH_SIZE = 10; // Default maximum hash table size

	private SList < HashTableData > [] hashArray; // Array containing the lists of keys

	public HashTable () { // default c'tor 
		setup(DEF_MAX_HASH_SIZE);
	}
	public HashTable ( int maxNumber ) { // c'tor
		if(maxNumber > 0)
			setup(maxNumber);
	}

	/**
	 * initializes the array and allocates it's memory
	 * 
	 * @param maxNumber - size of the array
	 */
	@SuppressWarnings("unchecked")
	private void setup ( int maxNumber ) { 
		hashArray = (SList<HashTableData>[])new SList<?>[maxNumber];
		for(int i = 0; i < hashArray.length ; ++i)
			hashArray[i] = new SList<HashTableData>();
	}
	/**
	 * 
	 * @param key - Integer
	 * @return output of the hash function (Modulus)
	 */
	int HashFunction ( int key ){
		return key % hashArray.length;
	}
	/**
	 * 
	 * @param key - String
	 * @return sends the sum of ASCII charachters to the Hash Function
	 */
	int HashFunction ( String key ) {
		int sum = 0;
		for( int i = 0 ; i < key.length() ; ++i)
			sum += key.charAt(i);
		return HashFunction(sum);
	}

	
	/**
	 * 
	 * @param searchElem - element we are searching
	 * @return true if the element was found, otherwise returns false
	 */
	public boolean retrieve ( HashTableData searchElem) {
		if (isEmpty())
			return false;
		int place = HashFunction(searchElem.getKey()); // getting the index from hash func
		hashArray[place].gotoBeginning();
		HashTableData tmp = hashArray[place].getCursor();
		while(true){
			if(tmp.getKey().equals(searchElem.getKey()))
				if(tmp.getDetails().getID() == searchElem.getDetails().getID())
					return true;
			if(!hashArray[place].gotoNext()) // returns false if the element was not found
				return false;
			tmp = hashArray[place].getCursor();
		}
	}
	
	
	/**
	 * 
	 * @param newElem - the new element we want to insert
	 * @return true
	 */
	public boolean insert ( HashTableData newElem) {
		if(isFull())
			return false;
		int place = HashFunction(newElem.getKey());
		hashArray[place].insert(newElem);
		return true;
	}

	
	/**
	 * 
	 * @param remElem - the element we want to remove
	 * @return - true if succeeded and false if the element was not found or the list is empty
	 */
	public boolean remove( HashTableData remElem) {
		if( isEmpty() ) {
			System.out.println("Empty List");			
			return false;
		}
		int place = HashFunction(remElem.getKey());
		boolean b = retrieve(remElem);
		if (!b){
			System.out.println("Element was not found");		
			return false;
		}
		hashArray[place].remove();
		return true;
		
	}
	
	/**
	 * clears the list
	 */
	public void clear() {
		for(int i = 0 ; i < hashArray.length ; ++i)
			hashArray[i].clear();
	}

	/**
	 * 
	 * @return true is the list is empty otherwise returns false
	 */
	public boolean isEmpty () {
		for(int i = 0 ; i < hashArray.length ; ++i)
			if(!hashArray[i].isEmpty())
				return false;
		return true;
	}
	/**
	 * 
	 * @return always returns false, because every element in the arrayt list is a linked list
	 */
	public boolean isFull () {
		return false;
	}

	/**
	 * prints all the elements in the structure
	 */
	public void showStructure() {
		if(isEmpty()){
			System.out.println("Empty Hash Table");
			return;
		}
		HashTableData tmp;
		for( int i = 0 ; i < hashArray.length ; ++i){
			hashArray[i].gotoBeginning();
			tmp = hashArray[i].getCursor();
			if( tmp == null) // the cell is null so skipping to the next one
				continue;
			while(true){
				if ( tmp != null)
					System.out.print(tmp.getKey() + " ");
				if(!hashArray[i].gotoNext())
					break;
				tmp = hashArray[i].getCursor();
			}
			System.out.println();
		}
	}
}