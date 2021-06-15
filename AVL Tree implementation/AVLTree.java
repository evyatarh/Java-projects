
public class AVLTree {

	// Data member
	private AVLTreeNode root; // Reference to the root node

	// Constructor
	public AVLTree ( ){

	}

	// Binary search tree manipulation methods

	// Insert element
	public void insert ( int newElement ){
		root = recInsert(root,newElement);
	}


	private AVLTreeNode recInsert(AVLTreeNode avlnode,int newElement){

		if(avlnode==null){
			avlnode = new AVLTreeNode(newElement,0, null,null);
			return avlnode;
		}

		else if(newElement<avlnode.getElem())
			avlnode.setLeft(recInsert(avlnode.getLeft(), newElement));


		else
			avlnode.setRight(recInsert(avlnode.getRight(), newElement));

		avlnode.setHeight(MaxHeight(avlnode)+1);//while the insertion we update each node height with max height func;

		if(avlnode.isBreachOfBalance()){
			avlnode=BalanceTree(avlnode);
			if(avlnode == null)return recInsert(avlnode, newElement);
		}
			

		return avlnode;
	}

	// each node return the max height between it left and right child's height.
	public int MaxHeight (AVLTreeNode avlnode){

		int heightRight=0,heightLeft=0;

		if(avlnode.getLeft()==null && avlnode.getRight()==null) return 0;

		else if(avlnode.getLeft()==null) return avlnode.getRight().getHeight();

		else if(avlnode.getRight()==null) return avlnode.getLeft().getHeight();

		heightRight = avlnode.getRight().getHeight();
		heightLeft = avlnode.getLeft().getHeight();

		if(Math.abs(heightLeft-heightRight)>1)avlnode.setBreachOfBalance(true);

		return heightRight > heightLeft ? heightRight:heightLeft;
	}


	private AVLTreeNode BalanceTree(AVLTreeNode avlNode){

		int x = whichType(avlNode);
		if(x==-1) return null;

		switch(x){

		case 1: return leftLeft(avlNode);

		case 2:  return leftRight(avlNode);

		case 3:  return rightLeft(avlNode);

		case 4:  return rightRight(avlNode);

		default:;
		}

		return null;
	}

	private int whichType(AVLTreeNode avlnode){
		
		if(avlnode.getLeft()==null && avlnode.getRight()==null)return -1;
		int x= avlnode.getRight().getHeight()-avlnode.getLeft().getHeight();

		if(x< 0){// left

			AVLTreeNode left=avlnode.getLeft();
			if(left.getRight()!=null && left.getLeft()==null) return 2;
			if(left.getRight()==null && left.getLeft()!=null) return 1; //if the left one exist and the right one is not
			x= left.getRight().getHeight()-left.getLeft().getHeight();

			if(x< 0)// left left
				return 1;
			return 2;//left right
		}
		else{//right
			
			AVLTreeNode right =avlnode.getRight();
			if(right.getRight()!=null && right.getLeft()==null) return 4;
			if(right.getRight()==null && right.getLeft()!=null) return 3; //if the left one exist and the right one is not
			x= right.getRight().getHeight()-right.getLeft().getHeight();

			if(x<0)//right left
				return 3;
			return 4;//right right
		}
	}


	private AVLTreeNode leftLeft(AVLTreeNode avlnode){

		AVLTreeNode k2 = avlnode; //root
		AVLTreeNode k1 = k2.getLeft(); //left
		AVLTreeNode x = k1.getLeft(); //left left
		AVLTreeNode y = k1.getRight();//left right

		k1.setLeft(x);
		k2.setLeft(y);
		k1.setRight(k2);

		return k1;
	}

	private AVLTreeNode rightRight(AVLTreeNode avlnode){

		AVLTreeNode k1 = avlnode; //root
		AVLTreeNode k2 = k1.getLeft(); //left
		AVLTreeNode x = k1.getLeft(); //left left
		AVLTreeNode y = k2.getLeft();//left right
		AVLTreeNode z = k2.getRight();

		k2.setRight(z);
		k1.setRight(y);
		k1.setLeft(x);
		k2.setLeft(k1);

		return k2;
	}

	private AVLTreeNode rightLeft(AVLTreeNode avlnode){

		AVLTreeNode k2 = avlnode; //root
		AVLTreeNode k1 = k2.getLeft(); //left
		AVLTreeNode k3 = k2.getRight();//left right
		AVLTreeNode A= k1.getLeft(); //left left
		AVLTreeNode B = k1.getRight();//left right
		AVLTreeNode C = k3.getLeft();// right left
		AVLTreeNode D = k3.getRight();//right right 

		k2.setRight(C);
		k2.setLeft(B);
		k1.setRight(k2);
		k3.setLeft(k1);

		return k3;

	}

	private AVLTreeNode leftRight(AVLTreeNode avlnode){

		AVLTreeNode k3 = avlnode; //root
		AVLTreeNode k1 = k3.getLeft(); //left
		AVLTreeNode k2 = k1.getRight();//left right
		AVLTreeNode A= k1.getLeft(); //left left
		AVLTreeNode B = k2.getLeft();// left right left
		AVLTreeNode C = k2.getRight();// left right right 
		AVLTreeNode D = k3.getRight();//right

		k1.setRight(B);
		k3.setLeft(C);
		k2.setRight(k3);
		k2.setLeft(k1);

		return k2;

	}



	public AVLTreeNode retrieve ( int searchKey ){ 
		return retriveRec(root, searchKey);
	}

	private AVLTreeNode retriveRec (AVLTreeNode avlnode , int searchKey){

		if(avlnode == null) return null;

		if(searchKey < avlnode.getElem()) return retriveRec(avlnode.getLeft(), searchKey);

		else if(searchKey > avlnode.getElem()) return retriveRec(avlnode.getRight(), searchKey);

		return avlnode;

	}


	public void clear( ){root = null;}// Clear tree
	

	public boolean isEmpty( ) {return root == null;} // Is tree empty?
	
	public boolean isFull( ) {return false;} // Is Tree full?
	
	public void showStructure ( ){
		printInOrder(root);
	}
	
	private void printInOrder(AVLTreeNode avlnode){
		
		if(avlnode == null) return;
		
		printInOrder(avlnode.getLeft());
		System.out.println(avlnode.getElem());
		printInOrder(avlnode.getRight());
		
	}
	// Output the tree structure


	public static void main(String[] args) throws Exception {
		AVLTree avl = new AVLTree();
		avl.insert(3);
		avl.insert(5);
		avl.insert(1);
		avl.insert(6);
		avl.insert(7);

	}
} // class AVLTree


