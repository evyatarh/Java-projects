
public class TestExprTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExprTree et = new ExprTree();
		 et.build("+34");
		 et.expression();
		 System.out.println(et.evaluate());
		 et.showStructure();
		 et.clear();
		 
		 System.out.println();
		 
		 et.build("*+34/52");
		 et.expression();
		 System.out.println(et.evaluate());
		 et.showStructure();
		 et.clear();
		 
		 System.out.println();
		 
		 et.build("-/*9321");
		 et.expression();
		 System.out.println(et.evaluate());
		 et.showStructure();
		 et.clear();
		 
		 System.out.println();
		 
		 et.build("*4+6-75");
		 et.expression();
		 System.out.println(et.evaluate());
		 et.showStructure();
		 et.clear();
		 
		 System.out.println();
		 
		 et.build("/02");
		 et.expression();
		 System.out.println(et.evaluate());
		 et.showStructure();
		 et.clear();
		 
		 System.out.println();
		 
		 et.build("7");
		 et.expression();
		 System.out.println(et.evaluate());
		 et.showStructure();
		 et.clear();
	}

}
