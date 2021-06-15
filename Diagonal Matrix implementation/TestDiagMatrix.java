
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class TestDiagMatrix {


	public static void main(String[] args) throws Exception {
		DiagonalMatrix dm = new DiagonalMatrix(4);
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		System.out.print("Enter Matrix values (end with Q) : ");
		int i,j;
		tokens.nextToken();
	
	while (!tokens.sval.equals("Q")){

		if(tokens.nval == StreamTokenizer.TT_NUMBER){ 
			System.out.println("Enter a commaned and not numbers");
		}
		else{
			switch(tokens.sval){
			
			case "Put":
				tokens.nextToken();
				i = (int)tokens.nval;
				tokens.nextToken();
				j = (int)tokens.nval;
				tokens.nextToken();
				double x = (double)tokens.nval;
				dm.put(i, j, x);
				break;
				
			case "Get":
				try{
				tokens.nextToken();
				i = (int)tokens.nval;
				tokens.nextToken();
				 j = (int)tokens.nval;
				dm.printElement(i, j);
				}catch(Exception e){
					System.out.println("The coordinates is higher then matrix's dimention");
				}
				break;
				
			case "Print":
				dm.printMatrix();
				break;
				
			case "MultCons":
				tokens.nextToken();
				i = (int)tokens.nval;
				dm.multByConstant(i);
				break;
				
			case "Tran":
				dm.tanspose();
				break;
				
			default:;
			}

			tokens.nextToken();

		}

	}
}
}
	
