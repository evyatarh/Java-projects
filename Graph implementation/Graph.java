public class Graph {

	public final int DEF_MAX_GRAPH_SIZE = 10;
	public static final int INFINITE_EDGE_WT = Integer.MAX_VALUE;

	private int size; // Actual number of vertices in the graph
	private Vertex [ ] vertexList; // Vertex list
	private int [ ][ ] adjMatrix; // Adjacency matrix (a 2D array)

	public Graph( ) {
		setup(DEF_MAX_GRAPH_SIZE);
	}

	public Graph ( int maxNumber ) {
		setup(maxNumber);
	}

	private void setup( int maxNumber ) {

		vertexList = new Vertex [maxNumber];
		adjMatrix = new int [maxNumber][maxNumber];
		size = 0;
	} 

	public void insertVertex ( Vertex newVertex ) {
		if(!isFull()){
			vertexList[size]=newVertex;
			size++;
		}
	} 

	public void insertEdge ( String v1, String v2, int wt ){
		int v1_index = index(v1);
		int v2_index = index(v2);

		setEdge(v1_index, v2_index, wt);
		setEdge(v2_index, v1_index, wt);

	}

	public Vertex retrieveVertex ( String v ) {
		if(index(v)!=-1)
			return new Vertex(v);
		return null;
	} 

	public int edgeWeight ( String v1, String v2 ) {

		int ret = getEdge(index(v1),index(v2));

		if(ret == -1) return INFINITE_EDGE_WT;
		return ret;
	} 

	public void removeVertex ( String v ) {
		int retIndex = index(v);
		if(!isFull() && retIndex > -1 ){
			size--;
			vertexList[retIndex] = vertexList[size];
			
			for (int i = 0; i < adjMatrix.length; i++) {
				setEdge(retIndex, i, adjMatrix[size][i]);
				setEdge( i,retIndex, adjMatrix[i][size]);
			}
		}
		
	
	} 
	public void removeEdge ( String v1, String v2 ) {
		
		int retIndex1 = index(v1);
		int retIndex2 = index(v2);

		setEdge(retIndex1,retIndex2,0);
		setEdge(retIndex2,retIndex1,0);

	} 

	public void clear ( ) {size = 0;} // Clear graph

	public boolean isEmpty ( ) { return size == 0;} // Is graph empty?
	public boolean isFull ( ) { return size == vertexList.length;} // Is graph full?

	public void showStructure (){
		
		if(isEmpty()) {System.out.println("Empty Graph");return;}
		
		System.out.println("Vertex List:");
		System.out.println("index\t|\tlable");
		
		for (int i = 0; i < size; i++) {
			System.out.println(i + "\t|\t" + vertexList[i].getLabel()); 
		}
		
		System.out.println("AdjMatrix:");
		System.out.print("From/To\t");
		
		for (int i = 0; i < size; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < size; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < size; j++) {
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}


	private int index ( String v ) {
		for(int i=0; i<size; i++){
			if(v.equals(vertexList[i].getLabel())) return i;
		}
		return -1;
	} // Converts vertex label to an adjacency matrix index
	public int getEdge ( int row, int col ) {
		if(row > adjMatrix.length || col > adjMatrix.length)return -1;
		return adjMatrix[row][col];
	} // Get edge weight using adjacency matrix indices
	private void setEdge ( int row, int col, int wt ) {
		if(row > adjMatrix.length || col > adjMatrix.length)return;
		adjMatrix[row][col] = wt;
	} // Set edge wt using adjacency matrix indices
} // class Graph
