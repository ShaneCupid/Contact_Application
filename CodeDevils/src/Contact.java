
import java.time.LocalTime;

public class Contact {
	protected String name;
	protected String phoneNumber;
	protected final int contactId;
	static int nextId = 1;
	protected final LocalTime createdAt;
	
	
	public Contact(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.contactId = nextId++;
		this.createdAt = LocalTime.now();
	}

	@Override
	public String toString() {
		return "Contact [name = " + name + ", phoneNumber = " + phoneNumber + "]";
	}
	
}
	
	

