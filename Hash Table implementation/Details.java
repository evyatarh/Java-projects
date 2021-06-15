
public class Details {
	String FirstName;
	int age;
	double average,ID;
	
	
	/**
	 *  Constructor receives the arguments, and initializes all the fields
	 * @param age
	 * @param average of the student
	 * @param First Name
	 * @param Id
	 */
	public Details(int age, double average, String FirstName , double Id) {
		this.ID = Id;
		this.FirstName = FirstName;
		this.average = average;
		this.age = age;
	}
	
	/* Getters And Setters */
	public double getID() {
		return ID;
	}

	public void setID(double iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}


}
