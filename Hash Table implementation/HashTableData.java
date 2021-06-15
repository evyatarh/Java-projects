public class HashTableData { //Node
	// Data members
	private String key; // Last name => key
	private Details details;

	// Constructor
	public HashTableData ( String key, Details d) {
		this.key = key;
		this.details = d;
	}
	
	/* Getters and Setters  */
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}
	
	
	
} // class HashTableData