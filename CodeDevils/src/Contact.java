
import java.time.LocalDateTime;
import java.util.regex.*;

public class Contact {
	protected String name;
	protected String phoneNumber;
	protected final int contactId;
	static int nextId = 1;
	protected final LocalDateTime createdAt;
	
	
	public Contact(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.contactId = nextId++;
		this.createdAt = LocalDateTime.now();
	}

	public static boolean isValid(String phone) {
		Pattern p = Pattern.compile(
	            "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
		
		Matcher m = p.matcher(phone);
		
		return (m.matches());
	}

	@Override
	public String toString() {
		return "Contact [name = " + name + ", phoneNumber = " + phoneNumber + "]";
	}
	
}
	
	

