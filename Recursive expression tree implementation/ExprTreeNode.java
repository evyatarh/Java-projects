public class ExprTreeNode{ // Facilitator class for the ExprTree
	// Data members
	private char key; // Expression tree element
	private ExprTreeNode left,right; // Reference to the left child and the right child

	// Constructor
	public ExprTreeNode ( char key, ExprTreeNode leftPtr, ExprTreeNode rightPtr ){
		this.key = key;
		left = leftPtr;
		right = rightPtr;
	}
	// Class Methods used by client class

	public char getKey() {
		return key;
	}
	public void setKey(char key) {
		this.key = key;
	}
	public ExprTreeNode getLeft() {
		return left;
	}
	public void setLeft(ExprTreeNode left) {
		this.left = left;
	}
	public ExprTreeNode getRight() {
		return right;
	}
	public void setRight(ExprTreeNode right) {
		this.right = right;
	}

	
} // class ExprTreeNode