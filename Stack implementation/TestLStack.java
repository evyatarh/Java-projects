
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
public class TestLStack {

	public TestLStack() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) throws Exception {
		DListStack<Integer> ds = new DListStack<Integer>();
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
				ds.push(x);
				break;
				
			case "Pop":
				Integer in = ds.pop();
				System.out.println(in==null?"The stack is empty":in);
				break;
				
			case "P":
				ds.showStructure();
				break;
				
			case "F":
				System.out.println(ds.isFull());
				break;
			
			case "E":
				System.out.println(ds.isEmpty());
				break;
				
			case "C":
				ds.clear();
				break;
			
				
			default:;
			}

			tokens.nextToken();

		}


	}
	}

	
}
