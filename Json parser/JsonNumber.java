package tar2;

public class JsonNumber implements JsonValue {
	
	private Number k;
	private char str;
	private boolean isE=false;
	private StringBuilder stb;
	private StringBuilder sbE; 
	
	public JsonNumber() {
		super();
		this.stb = new StringBuilder();
		this.sbE = new StringBuilder();
	}

	@Override
	public JsonValue get(int i)throws JsonQueryException {
		// TODO Auto-generated method stub
		return this.get(i);
	}

	@Override
	public JsonValue get(String s) throws JsonQueryException{
		// TODO Auto-generated method stub
		return this.get(s);
	}


	public char getStr() {
		return str;
	}

	public String setStr(char str) {
		this.str = str;
		
		if(isE)
			return sbE.append(str).toString();
		else
			return stb.append(str).toString();
		
	}

	public void setK(Number k) {
		this.k = k;
	}

	public void setE(boolean isE) {
		this.isE = isE;
	}
	
	public String toString() {
		
		return k.toString();
	
	
}
	
	

}
