
public class AVLTreeNode {

	// Data members
	private int elem; // Binary search tree element
	private int height ; // Height of the sub-tree
	private AVLTreeNode left,right; // Reference to the left child and the right child
	private boolean BreachOfBalance;
	// Constructor
	public AVLTreeNode ( int elem, int height, AVLTreeNode leftPtr, AVLTreeNode rightPtr ){
		this.elem = elem;
		this.height = height;
		left = leftPtr;
		right = rightPtr;
		BreachOfBalance=false;
	}



	public boolean isBreachOfBalance() {
		return BreachOfBalance;
	}



	public void setBreachOfBalance(boolean breachOfBalance) {
		BreachOfBalance = breachOfBalance;
	}



	public int getElem() {
		return elem;
	}


	public void setElem(int elem) {
		this.elem = elem;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public AVLTreeNode getLeft() {
		return left;
	}


	public void setLeft(AVLTreeNode left) {
		this.left = left;
	}


	public AVLTreeNode getRight() {
		return right;
	}


	public void setRight(AVLTreeNode right) {
		this.right = right;
	}



}// class AVLTreeNode
