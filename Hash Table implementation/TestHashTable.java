import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestHashTable {

	public static void main(String args[]) throws IOException {
		String firstName,key;
		double avg,ID;
		int age;
		Details details;
		HashTableData htd;
		HashTable hashTable = new HashTable();
		
		
		//SList<HashTableData> slist = new SList<HashTableData>();
		
		// Initialize reader - To read a character at a time
		InputStreamReader reader = new InputStreamReader(System.in);

		// Initialize the tokenizer -To read tokens (words and numbers separated
		// by whitespace)
		StreamTokenizer tokens = new StreamTokenizer(reader);


		System.out.print("Enter the elements of the list (end with Q) : " + "\n");
		System.out.println("Please enter them in this order : last name (key), first name,Id,age,average");
		// Keep reading as long as word (not number!) has not been entered
		
		
		Character tmp; //for input from the user
		while ((tokens.nextToken()) == StreamTokenizer.TT_WORD){
			switch(tokens.sval){ //inserting sval the string from the input
			
				// ends the program
				case "Q": return;
			
				

				case "add":  // entering key(Last Name),FirstName,ID,age,average
					tokens.nextToken();
					key = tokens.sval;
					
					tokens.nextToken();
					firstName = tokens.sval;
					
					tokens.nextToken();
					ID = tokens.nval;
					
					tokens.nextToken();
					age = (int)tokens.nval;
					
					tokens.nextToken();
					avg = (int)tokens.nval;
					
					details = new Details(age,avg,firstName,ID);
					htd = new HashTableData(key, details);
					hashTable.insert(htd);
					System.out.println("Element added");
					break;


				case "delete": 
					tokens.nextToken();
					key = tokens.sval;
					
					tokens.nextToken();
					firstName = tokens.sval;
					
					tokens.nextToken();
					ID = tokens.nval;
					
					tokens.nextToken();
					age = (int)tokens.nval;
					
					tokens.nextToken();
					avg = (int)tokens.nval;
					
					details = new Details(age,avg,firstName,ID);
					htd = new HashTableData(key, details);
					if(hashTable.remove(htd))
						System.out.println("Element removed");
					
				break;


				case "clear":
					hashTable.clear();
					System.out.println("Hash Table is cleared");
				break;
				
				
				case "find":
					tokens.nextToken();
					key = tokens.sval;
					
					tokens.nextToken();
					firstName = tokens.sval;
					
					tokens.nextToken();
					ID = tokens.nval;
					
					tokens.nextToken();
					age = (int)tokens.nval;
					
					tokens.nextToken();
					avg = (int)tokens.nval;
					
					details = new Details(age,avg,firstName,ID);
					htd = new HashTableData(key, details);
					
					if(!hashTable.retrieve(htd))
						System.out.println("Element not found");
					else
						System.out.println("Element found");
				break;
				
				
				// transposes the matrix
				case "full":
					if(!hashTable.isFull())
						System.out.println("The list is not full");
					else
						System.out.println("The list is full");
				break;
				
				
				case "empty":
					if(hashTable.isEmpty())
						System.out.println("The list is empty");
					else
						System.out.println("The list is not empty");
				break;
				
				
				case "print":
					hashTable.showStructure();
				break;
				
			}
		}//while
	}// main
}
