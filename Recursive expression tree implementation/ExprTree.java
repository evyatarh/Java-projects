
public class ExprTree {
	// Data member
	private ExprTreeNode root; // Reference to the root node
	private char opArray[];
	private int index;
	// Constructor
	public ExprTree ( ){
		opArray = new char[4];
		opArray[0] = '*';
		opArray[1] = '/';
		opArray[2] = '+';
		opArray[3] = '-';
		index = 0;
	}
	
	// Clear tree
	public void clear ( ) {root = null;}
	
	// Build tree from prefix expression
	public void build (String expression ){ 
		root = build_rec(expression,root);
		index = 0;
	}
	private ExprTreeNode build_rec(String expression, ExprTreeNode node){
		
		ExprTreeNode temp;
		
		if(expression.isEmpty()) return null;
		
		if(isOperator(expression.charAt(index))){
			node = new ExprTreeNode(expression.charAt(index),null,null);
			index++;
			temp = build_rec(expression, node.getLeft());
			node.setLeft(temp);
			index++;
			temp = build_rec(expression, node.getRight());
			node.setRight(temp);
			
		}
		else
			node = new ExprTreeNode(expression.charAt(index),null,null);
		
		return node;
		}
		
	public boolean isOperator(char c){
		for(int i = 0; i < 4; i++)
			if(opArray[i] == c) return true;
		return false;
	}

	// Output expression in infix form
	public void expression ( ){printInOrder(root,true);System.out.println(); }
	// Put ( ) for the expressions and the operands : ((3)+(5)) * (4)
	private void printInOrder(ExprTreeNode node,boolean flag){
		
		if(node == null)return;
		
		if(!flag)System.out.print("(");
		printInOrder(node.getLeft(),false);
		System.out.print(node.getKey());
		printInOrder(node.getRight(),false);
		if(!flag)System.out.print(")");
	}
	
	// Evaluate expression.
	public float evaluate ( ){return recEvaluate(root); }
	private float recEvaluate(ExprTreeNode node){
		float sumTotal = 0,sumRight = 0,sumLeft = 0;
		
		if(node == null) return 0;
		
		sumLeft += recEvaluate(node.getLeft()); //get the left tree and calculate him
		sumRight += recEvaluate(node.getRight()); //get the right tree and calculate him
		
		
		if(isOperator(node.getKey())){
			switch(node.getKey()){
			case '+': sumTotal += sumLeft + sumRight;break;
			case '-': sumTotal += sumLeft - sumRight;break;
			case '*': sumTotal += sumLeft * sumRight;break;
			case '/': sumTotal += sumLeft / sumRight;break;
			default:;
			}
		}
		else return (node.getKey() - '0');
		
			return sumTotal;
	}
	
	// Output the tree structure in prefix form
	public void showStructure ( ){ printPreorder(root);System.out.println();}
	private void printPreorder(ExprTreeNode node) 
    { 
        if (node == null) return;
  
        /* first print data of node */
        System.out.print(node.getKey() + " "); 
  
        /* then recur on left subtree */
        printPreorder(node.getLeft()); 
  
        /* now recur on right subtree */
        printPreorder(node.getRight()); 
	}
		
} // class ExprTree