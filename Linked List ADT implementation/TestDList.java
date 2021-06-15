import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class TestDList {

	public TestDList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		DList<Character> dlist = new DList<Character>();
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		System.out.print("Enter Matrix values (end with Q) : ");
		char x;
		tokens.nextToken();
	
	while (!tokens.sval.equals("Q")){

		if(tokens.nval == StreamTokenizer.TT_NUMBER){ 
			System.out.println("Enter a commaned and not numbers");
		}
		else{
			switch(tokens.sval){
			
			case "Add":
				tokens.nextToken();
				x = tokens.sval.charAt(0);
				dlist.insert(x);
				break;
				
			case "Del":
				dlist.remove();
				break;
				
			case "Rep":
				tokens.nextToken();
				x = tokens.sval.charAt(0);
				dlist.replace(x);
				break;
				
			case "Cur":
				System.out.println(dlist.getCursor());
				break;
				
			case "N":
				dlist.gotoNext();
				break;
				
			case "P":
				dlist.gotoPrior();
				break;
				
			case "B":
				dlist.gotoBeginning();
				break;
				
			case "End":
				dlist.gotoEnd();
				break;
				
			case "E":
				System.out.println(dlist.isEmpty());
				break;
				
			case "C":
				dlist.clear();
				break;
				
			case "Show":
				dlist.showStructure();
				break;
				
			default:;
			}

			tokens.nextToken();

		}


	}
	}

	
}
