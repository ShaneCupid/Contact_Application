import java.io.Serializable;

public class Person extends Contact implements Serializable{
	private String email;
	private String dob;
	
	public Person(String name, String phoneNumber, String email, String dOB) {
		super(name, phoneNumber);
		this.email = email;
		dob = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDOB() {
		return dob;
	}

	public void setDOB(String dOB) {
		dob = dOB;
	}

	@Override
	public String toString() {
		return "Person [email=" + email + ", dob=" + dob + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", contactId=" + contactId + ", createdAt=" + createdAt + "]";
	}

	

	
}

