package tar2;

import java.util.HashMap;
import java.util.Map;

public class JsonObject implements JsonValue {
	
	private Map <String,JsonValue> o;

	
	public JsonObject() {
		
		o = new HashMap<String,JsonValue>();
		
	}

	@Override
	public JsonValue get(int i)throws JsonQueryException {
		// TODO Auto-generated method stub
		return this.o.get(i);
	}

	@Override
	public JsonValue get(String s)throws JsonQueryException {
	
		return this.o.get(s);
	}
	
	
	public void setO(String s,JsonValue j) {
		o.put(s,j);
	}

	
	

	public String toString() {
		
		StringBuilder job = new StringBuilder();
		job.append('{');
		
		for(Map.Entry<String,JsonValue> it : o.entrySet()){
			job.append('<');
			job.append(it.getKey());
			job.append(':');
			job.append(it.getValue().toString());
			job.append('>');
		}
		job.append('}');
		
		return job.toString();
	}



}
