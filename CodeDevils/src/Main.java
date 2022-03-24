import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	static File file = new File ("C:\\Users\\JonRodriguez-Castill\\OneDrive - Xpanxion\\Desktop\\GitHub\\CodeDevils\\Contacts.txt");
	static HashMap<Integer, Contact> map = new HashMap<>();

	public static void main(String[] args) {

		// Iterator<Map.Entry<Integer, Contact>> it = map.entrySet().iterator();

		String displayMenu = "[add, list, count, info, delete, search, exit]";

		Scanner input = new Scanner(System.in);

		String choice;
		String name;
		String phone;
		String email;
		String dob;
		String website;
		Integer id;
		Integer num = 1;
		Contact newContact;
		
		

		while (true) {

			System.out.println(displayMenu);
			choice = input.nextLine();

			if (choice.equalsIgnoreCase("add")) {
				System.out.println("Enter Person or Organization:");
				choice = input.nextLine();

				if (choice.equalsIgnoreCase("person")) {
					System.out.println("Name: ");
					name = input.nextLine();

					System.out.println("Number: ");
					phone = input.nextLine();

					if (!Contact.isValid(phone)) {
						phone = "No Number";
					}

					System.out.println("Email: ");
					email = input.nextLine();

					System.out.println("DOB: ");
					dob = input.nextLine();

					newContact = new Person(name, phone, email, dob);
					map.put(newContact.getContactId(), newContact);
					num++;

				}

				else if (choice.equalsIgnoreCase("organization")) {

					System.out.println("Name: ");
					name = input.nextLine();

					System.out.println("Number: ");
					phone = input.nextLine();

					if (!Contact.isValid(phone)) {
						phone = "No Number";
					}

					System.out.println("Website: ");
					website = input.nextLine();

					newContact = new Organization(name, phone, website);
					map.put(newContact.getContactId(), newContact);
					num++;
				}

			}

			else if (choice.equalsIgnoreCase("list")) {

				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
					System.out.println(eachContactMapping.getValue().getContactId() + " : "
							+ eachContactMapping.getValue().getName());
				}

			}

			else if (choice.equalsIgnoreCase("count")) {
				System.out.println(map.size());

			}

			else if (choice.equalsIgnoreCase("info")) {

				// for (int i = 1; i <= map.size(); i++) {
				// System.out.println(map.get(i));

				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
					System.out.println(eachContactMapping.getValue());
				}

				try {
					System.out.println("please enter ID: ");

					id = input.nextInt();

					if (map.containsKey(id)) {

						System.out.println(map.get(id));
					}

					input.nextLine();
				}

				catch (NullPointerException e) {

					System.out.println(e.getStackTrace());
				}

				catch (InputMismatchException e) {
					System.out.println(e.getStackTrace());
				}
			}

			else if (choice.equalsIgnoreCase("delete")) {

				// for (int i = 1; i <= map.size(); i++) {
				// System.out.println(map.get(i));

				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
					System.out.println(eachContactMapping.getValue());
				}

				try {
				System.out.println("Please enter contact ID: ");

				id = input.nextInt();

				if (map.containsKey(id)) {
					map.remove(id);

				}

				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
					System.out.println(eachContactMapping.getValue());
				}
				input.nextLine();
				
				}
				
				catch (NullPointerException e) {

					System.out.println(e.getStackTrace());
				}

				catch (InputMismatchException e) {
					System.out.println(e.getStackTrace());
				}
			}

			else if (choice.equalsIgnoreCase("search")) {

				System.out.println("Enter your search query");

				choice = input.nextLine().toLowerCase();

				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {

					if (eachContactMapping.getValue().getName().contains(choice)) {
						System.out
								.println(eachContactMapping.getKey() + " : " + eachContactMapping.getValue().getName());
					}

				}
			}

			if (choice.equalsIgnoreCase("exit")) {
				break;
			}

		}
		
		System.out.println("Program Executed");
		
		try {
		
		FileOutputStream fs = new FileOutputStream(file);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		
		for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
			os.writeObject(eachContactMapping.getValue());
		}
		
		os.close();
		
		}
		
		catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
		
		input.close();
		
	}

}
