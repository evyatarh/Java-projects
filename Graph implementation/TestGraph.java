import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
public class TestGraph {

	public static void main(String args[]) throws IOException {

		Graph graph = new Graph();
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);

		System.out.print("Enter the City name (end with Q) : ");

		String v1, v2;
		tokens.nextToken();
		while (!tokens.sval.equals("Q")){


			if(tokens.nval == StreamTokenizer.TT_NUMBER){ 
				System.out.println("Enter a commaned and not numbers");
			}
			else{
				switch(tokens.sval){

				case "InsertVertex":
					tokens.nextToken();
					v1 = tokens.sval;
					graph.insertVertex(new Vertex(v1));
					break;

				case "InsertEdge":
					tokens.nextToken();
					v1 = tokens.sval;
					tokens.nextToken();
					v2 = tokens.sval;
					tokens.nextToken();
					int wt = (int)tokens.nval;
					graph.insertEdge(v1, v2, wt);
					break;	

				case "Show":
					graph.showStructure();
					break;

				case "DelVertex":
					tokens.nextToken();
					v1 = tokens.sval;
					graph.removeVertex(v1);
					break;

				case "DelEdge":
					tokens.nextToken();
					v1 = tokens.sval;
					tokens.nextToken();
					v2 = tokens.sval;
					graph.removeEdge(v1, v2);
					break;

				case "EdgeWeight":
					tokens.nextToken();
					v1 = tokens.sval;
					tokens.nextToken();
					v2 = tokens.sval;
					System.out.println(graph.edgeWeight(v1, v2));
					break;

				case "RetVertex":
					tokens.nextToken();
					v1 = tokens.sval;
					System.out.println(graph.retrieveVertex(v1).getLabel());
					break;

				case "E":
					System.out.println(graph.isEmpty());
					break;

				case "F":
					System.out.println(graph.isFull());
					break;

				case "C":
					graph.clear();
					break;

				default:;
				}

				tokens.nextToken();

			}


		}
	}
}

