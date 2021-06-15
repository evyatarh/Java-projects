import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestAstack {

	public TestAstack() {
		// TODO Auto-generated constructor stub
	}




	public static void main(String[] args) throws Exception {
		ArrayStack<Integer> as = new ArrayStack<Integer>();
 		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		System.out.print("Enter Matrix values (end with Q) : ");
		int x;
		tokens.nextToken();
	
	while (!tokens.sval.equals("Q")){

		if(tokens.nval == StreamTokenizer.TT_NUMBER){ 
			System.out.println("Enter a commaned and not numbers");
		}
		else{
			switch(tokens.sval){
			
			case "Push":
				tokens.nextToken();
				x = (int)tokens.nval;
				as.push(x);
				break;
				
			case "Pop":
				Integer in = as.pop();
				System.out.println(in==null?"The stack is empty":in);
				break;
				
			case "P":
				as.showStructure();
				break;
				
			case "F":
				System.out.println(as.isFull());
				break;
			
			case "E":
				System.out.println(as.isEmpty());
				break;
				
			case "C":
				as.clear();
				break;
			
				
			default:;
			}

			tokens.nextToken();

		}


	}
	}

	
}
