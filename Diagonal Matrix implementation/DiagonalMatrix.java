
public class DiagonalMatrix {
	private static int Max_Matrix_Size=10;
	private double list[];
	private int size;
	private int N;
	private boolean flag;
	private int constC;

	public DiagonalMatrix() {

		setup(Max_Matrix_Size);
	}
	public DiagonalMatrix(int N){
		setup(N);
	}
	private void setup (int size){

		if (size > 0){
			flag = false;
			constC = 1;
			N = size;
			this.size = 2*size - 1;
			list = new double[this.size];
		}

	}
	public double get(int i, int j)throws Exception{

		if(i > N || j > N){
			
			throw new Exception();
		}
		
		if(flag){
			int temp = i;
			i=j;
			j=temp;
		}


		if(i==j)return constC*list[size/2];
		if(i>j)return constC*list[N-(i-j)-1];
		else return constC*list[(j-i)+N-1];

	}
	public void put(int i, int j, double x) throws Exception{

		if(i > N || j > N){
			
			throw new Exception();
		}
   
		if(i==j) list[size/2]=x;
		if(i>j)list[N-(i-j)-1]=x;
		if(i<j)list[(j-i)+N-1]=x;
	}

	public void tanspose( ){ flag = !flag;}

	public void multByConstant (int C ){constC = C;}

	public void printElement(int i, int j) throws Exception{
		System.out.print((int)(get(i,j)));
	}
	public void printMatrix( ) throws Exception{
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				printElement(i,j);
			}
		System.out.println();
		}
	}


	}
