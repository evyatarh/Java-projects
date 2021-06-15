package tar2;

import java.util.ArrayList;
import java.util.List;

public class JsonArray implements JsonValue {
	
	private List<JsonValue> a;
	

	public JsonArray() {
		
		a = new ArrayList<JsonValue>();
		
	}
	
	@Override
	public JsonValue get(int i) throws JsonQueryException{
		// TODO Auto-generated method stub
		return a.get(i);
	}

	@Override
	public JsonValue get(String s)throws JsonQueryException {
		
		
		return this.get(s);
	}


	
	public void addJsonValues(JsonValue ajv){
	
		this.a.add(ajv);
		
		
	}
	public String toString() {
		
		StringBuilder sba = new StringBuilder();
		sba.append('[');
		for(int i=0;i<a.size();i++){
			
			sba.append(a.get(i));	
			sba.append(',');
		}
		sba.append(']');
		
		return sba.toString();
	}


}
