package tar2;




public class JsonString implements JsonValue {
	
	private String s;
	private StringBuilder jstring;
	private JsonObject jvjv;


	public JsonString() {
		super();
		jstring = new StringBuilder();
		jvjv = new JsonObject();
	}


	@Override
	public JsonValue get(int i) throws JsonQueryException{
		
		return jvjv.get(i);
	}

	@Override
	public JsonValue get(String s) throws JsonQueryException {
		// TODO Auto-generated method stub
		
		return jvjv.get(s);
	}
	
	public String getS() {
		return s;
	}

	public void setc(Character c) {
		
		jstring.append(c);
	}
	

	public void setS(String s) {
		this.s = s;
	}
	
	public String toString() {
		
	
	
		return jstring.toString();
	}
}
