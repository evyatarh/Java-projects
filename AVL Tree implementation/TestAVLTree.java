import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class TestAVLTree {

	public static void main(String[] args) throws IOException {

		int key;
		AVLTree tree = new AVLTree();
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		System.out.print("Enter  values (end with Q) : ");

		tokens.nextToken();

		while (!tokens.sval.equals("Q")){

			if(tokens.nval == StreamTokenizer.TT_NUMBER)
				System.out.println("Enter a commaned and not numbers");
			
			else{
				
				switch(tokens.sval){

				case("ADD"): 
					tokens.nextToken();
				key= (int)tokens.nval;
				tree.insert(key);
				break;

				case("FIND"):
					tokens.nextToken();
				key =(int)tokens.nval;
				AVLTreeNode temp=tree.retrieve(key);
				if(temp!=null)
					System.out.println("key: "+temp.getElem()+" retrieved");
				else
					System.out.println("key not found");
				break;

				case("K"):
					tree.showStructure();
				break;

				case("E"): 
					System.out.println("empty?: "+tree.isEmpty());
				break;

				case("F"): 
					System.out.println("full?: "+tree.isFull());
				break;

				case("C"):
					tree.clear();  //erase the list
				break;

				default:;
				}

				tokens.nextToken();

			}
		}


	}
}


