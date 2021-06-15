
public class HeapData {

	private Student key;
	private int priority;
	public HeapData(Student key,int priority) {
		this.key = key;
		this.priority = key.getDS_grade();
	}
	public Student getKey() {
		return key;
	}
	public int getPriority() {
		return priority;
	}
	public void setKey(Student key) {
		this.key = key;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	

}
