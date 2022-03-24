import java.io.Serializable;

public class Organization extends Contact implements Serializable{
	private String website;

	public Organization(String name, String phoneNumber, String website) {
		super(name, phoneNumber);
		this.website = website;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Organization [website=" + website + ", name=" + name + ", phoneNumber=" + phoneNumber + ", contactId="
				+ contactId + ", createdAt=" + createdAt + "]";
	}


	
}
