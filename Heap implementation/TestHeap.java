import java.io.*;
public class TestHeap {

	public static void main(String args[]) throws IOException {
		
		Heap heap = new Heap();
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);

		System.out.print("Enter the Student grade (end with QUIT) : ");

		tokens.nextToken();
		while (!tokens.sval.equals("Q")){

		
			if(tokens.nval == StreamTokenizer.TT_NUMBER){ 
				System.out.println("Enter a commaned and not numbers");
			}
			else{
				switch(tokens.sval){

				case "Add":
					tokens.nextToken();
					int grade = (int)tokens.nval;
					Student st = new Student(grade);
					HeapData heapdata = new HeapData(st, grade);
					heap.insert(heapdata);
					break;
				case "Show":
					heap.showStructure();
					break;
				case "Del":
					System.out.println(heap.removeMin().getPriority());
					break;
				case "E":
					System.out.println(heap.isEmpty());
					break;
				case "F":
					System.out.println(heap.isFull());
					break;
				case "C":
					heap.clear();
					break;

				default:;
				}

				tokens.nextToken();

			}


		}
	}
}

