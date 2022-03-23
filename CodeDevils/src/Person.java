
public class Person extends Contact{
	private String email;
	private String DOB;
	
	public Person(String name, String phoneNumber, String email, String dOB) {
		super(name, phoneNumber);
		this.email = email;
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Person [email = " + email + ", DOB = " + DOB + "]";
	}

	
}
