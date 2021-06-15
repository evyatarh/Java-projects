package tar2;

import java.io.File;
import java.io.FileNotFoundException;


public class JsonBuilder implements JsonValue {
	
	private CharScanner cs;
	private JsonValue v;
	private JsonValue v2;
	private JsonValue v3;
	private JsonObject jo;
	private JsonObject jo2;
	private static boolean flag = false;
	



	public JsonBuilder(File f) throws FileNotFoundException {
		
		this.cs = new CharScanner(f);
		jo = new JsonObject();
		jo2 = new JsonObject();
	
	}
	
	

	
	public JsonValue parseValue()throws JsonSyntaxException{
		
		if(Character.isDigit(cs.peek()))
			return parseNumber();
		char c = cs.next();

		switch(c)
		{
		case '{':
			return parseObject();
			
		case '[':
			return parseArray();
			
		case '"':
			return parseString();
			
		case '-':
			return parseNumber();
	
		
		}
		return parseValue();
		
	}
	

	public JsonArray parseArray()throws JsonSyntaxException{
		
		JsonValue jv;
		
		
		JsonArray ja = new JsonArray();
		
		while(cs.peek()!=']'){
			if(cs.peek()==','){
				cs.next();
				
			}
		jv = parseValue();
		ja.addJsonValues(jv);
		}
		cs.next();
		return ja;
		
	}
	
	public JsonObject parseObject()throws JsonSyntaxException{
		
	
	while(cs.peek()!='}') {
		
			if(cs.peek()=='"'||cs.peek()==','||cs.peek()=='[')
			{
					
					v = parseValue();
	
					if(cs.peek()==':'){
						cs.next();
						if(cs.peek()=='{'){
							flag=true;
							setV3(v);
							
							
							jo.setO(v3.toString(),parseValue());
							flag=false;
							break;
							
						}
					}
				
						
					v2 = parseValue();
					
					if(cs.peek()=='}'){
						cs.next();
						
						if(cs.peek()=='}'){
							jo2.setO(v.toString(),v2);
							return jo2;
						}
						
					}
						
						if(flag)
							jo2.setO(v.toString(),v2);
						else
						jo.setO(v.toString(),v2);
			}
			
					}
					
					
				
	
		
		return jo;
					
	}
			
	

	public JsonString parseString()throws JsonSyntaxException{
	
		JsonString js = new JsonString();
		 
		

		while(cs.peek()!='"'){
		
			if(cs.peek()=='\\')
			{
				cs.next();
		
				if(cs.peek()=='\\')
					js.setc('\\');
				
				if(cs.peek()=='\"')
					js.setc('\"');
					
			}
				else
				{
					
					js.setc(cs.next());
					
				}
		
			js.setS(js.toString());
		}
		
		cs.next();
	return js;	
	
	}
	
	
	public JsonNumber parseNumber()throws JsonSyntaxException{
		
		JsonNumber jn = new JsonNumber();
		String ret="0",retE="0";
		boolean flag=false,afterEnumbers=false;;
		
	
		while(cs.peek()!=',')
		{
			
			if(cs.peek()=='.'){
				jn.setStr(cs.next());
				flag=true;
			}
			

			
			if(cs.peek()=='E'||cs.peek()=='e'){
				afterEnumbers=true;
				cs.next();
				if(cs.peek()=='+')
					cs.next();
			}
			if(afterEnumbers){
				jn.setE(afterEnumbers);
				retE=jn.setStr(cs.next());
				
			}
		else{
			jn.setE(false);
			
			ret = jn.setStr(cs.next());
		}
			
			}
		
		double number =Double.parseDouble(ret);
		double numbersAfterE = Double.parseDouble(retE);
		
		numbersAfterE=Math.pow(10,numbersAfterE);
		number*=numbersAfterE;
		
		if(!flag)
			jn.setK((int)number);
		else
			jn.setK(number);
		
			return jn;
		}
	


	@Override
	public JsonValue get(int i)throws JsonQueryException {
		
		return jo.get(i);
	}

	@Override
	public JsonValue get(String s)throws JsonQueryException {
		
		
		return jo.get(s);
	}
	
	public JsonValue getV() {
		return v;
	}


	public void setV(JsonValue v) {
		this.v = v;
	}
	
	public JsonValue getV3() {
		return v3;
	}




	public void setV3(JsonValue v3) {
		this.v3 = v3;
	}

	
	public String toString() {

		
		try {
			parseValue();
			
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jo.toString();
	}
}
