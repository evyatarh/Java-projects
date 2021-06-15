import java.util.Scanner;

public class checkBalancedBrackets {

	private DListStack<Integer> dListS;
	private ArrayStack<Integer> arrayS;
	private char parenthesisOpeners[];
	private char parenthesisClosers[];
	private int arrayIndex;

	/*  0 1 2 
	 * [(|[|{]
	 * [)|]|}]
	 * we build two assists arrays, the first contains the openers parenthesis and
	 * the second contains the closers parenthesis.
	 * we push into the stack the index of the opener parenthesis
	 * and when a closer appear we pop and check if the indexes are the same.  
	 */
	
	public checkBalancedBrackets(){
		dListS = new DListStack<Integer>();
		arrayS = new ArrayStack<Integer>();
		parenthesisOpeners = new char[3];
		parenthesisClosers = new char[3];
		initializeOpeners();
		initializeClosers();
		arrayIndex = 0;
	}

	private void initializeOpeners(){
		parenthesisOpeners[0]='(';
		parenthesisOpeners[1]='[';
		parenthesisOpeners[2]='{';
	}
	private void initializeClosers(){
		parenthesisClosers[0]=')';
		parenthesisClosers[1]=']';
		parenthesisClosers[2]='}';
	}
	public boolean IsCloser( char sign){
		for (int i = 0; i < parenthesisClosers.length; i++) {
			if(parenthesisClosers[i] == sign){
				arrayIndex=i;
				return true;
			}
		}
		return false;
	}
	public boolean IsOpener( char sign){
		for (int i = 0; i < parenthesisOpeners.length; i++) {
			if(parenthesisOpeners[i] == sign){
				arrayIndex=i;
				return true;
			}
		}
		return false;
	}
	public boolean checkParenthesisDliststack(String regularExpression) throws Exception{

		for (int i = 0; i < regularExpression.length(); i++) {
			if(arrayS.isEmpty() && IsCloser(regularExpression.charAt(i))) return false;
			if(IsOpener(regularExpression.charAt(i))) arrayS.push(arrayIndex);
			else if(IsCloser(regularExpression.charAt(i))){
				if(arrayS.pop() != arrayIndex)
					return false;
			}
		}
		return (arrayS.isEmpty()==true)? true: false;



	}
	
	public boolean checkParenthesisAstack(String regularExpression) throws Exception{

		for (int i = 0; i < regularExpression.length(); i++) {
			//if the stack is empty and the character is closer so false
			if(dListS.isEmpty() && IsCloser(regularExpression.charAt(i))) return false;
			//if is opener so push the index to the stack
			if(IsOpener(regularExpression.charAt(i))) dListS.push(arrayIndex);
			//if is closer, pop and check if the index are match to the character
			else if(IsCloser(regularExpression.charAt(i))){
				if(dListS.pop() != arrayIndex)
					return false;
			}
		}
		return (dListS.isEmpty()==true)? true: false;



	}
	public static void main(String[] args) throws Exception { 
		checkBalancedBrackets cbB = new checkBalancedBrackets();
		Scanner sc = new Scanner(System.in);

		System.out.println(cbB.checkParenthesisAstack(sc.nextLine()));
		System.out.println(cbB.checkParenthesisDliststack(sc.nextLine()));

	}


}

