
public class Heap {
	private static final int DEF_MAX_HEAP_SIZE = 10; // Default maximum heap size
	// Data members
	private int size; // Actual number of elements in the heap
	private HeapData [ ] element; // Array containing the heap elements

	// Constructor: default size
	public Heap ( ){
		setup(DEF_MAX_HEAP_SIZE);
	}

	// Constructor: specific size
	public Heap ( int maxNumber ){
		setup(maxNumber);
	}

	// Called by constructors only
	private void setup ( int maxNumber ){
		this.size = 0;
		element = new HeapData[maxNumber+1];
		HeapData heapdata = new HeapData(new Student(-32765),-32765);
		element[0] = heapdata;
		

	}

	// Insert element
	public void insert ( HeapData newElement ){

		size++;

		if(size == 1)
			element[1] = newElement;

		
		else
		{
			for(int i = size;i>=1;i/=2){
				if(newElement.getPriority()>=element[i/2].getPriority()){
					element[i] = newElement;
					break;
				}
				else
					element[i] = element[i/2];
			}
		}
		


	}
	
	public HeapData removeMin ( ){
		HeapData temp = element[1];
		HeapData lastElement = element[size];
		size--;
		int hole=1;
		for(int i=2; i<=size; i*=2){
			if(element[i].getPriority() <= element[i+1].getPriority()){
				element[hole] = element[i];
				hole = i;
			}
			else{
				element[hole] = element[i+1];
				hole = i+1;
			}
		}
		element[hole] = lastElement;
		return temp;
	}


	// Clear heap: Make it efficient!!
	public void clear ( ){size = 0;}
	// Heap status methods
	public boolean isEmpty ( ){return (size == 0);}
	public boolean isFull ( ){return (element.length == size);}
	// Output the heap structure
	public void showStructure ( ){
		for (int i = 1; i <= size; i++) 
			System.out.print(element[i].getPriority() + " ");
		
	}
	// Build heap structure from the given array elements
	public void buildHeap ( HeapData [ ] Array){
		for (int i = 0; i <= size; i++) 
			heapify(Array, i);
	} 

	private int Left(int i){return 2*i;}

	private int Right(int i){return 2*i +1;}

	private void heapify (HeapData [ ] Array, int i){
		
		if(i>size)return;
		int min;
		if(Left(i) <= size && Array[Left(i)].getPriority() < Array [i].getPriority())
			min = Left(i);
		else 
			min = i;
		if (Right(i) <=size && Array[Right(i)].getPriority() < Array [min].getPriority())
			min = Right(i);
		if(min != i) swap(Array, i, min);

		heapify(Array, min);
	}
	
	private void swap(HeapData [ ] Array, int i,int j){
		HeapData temp = Array[i];
		Array[i] = Array[j];
		Array[j] = temp;
	}

}
