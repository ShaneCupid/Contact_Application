import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static HashMap<Integer, Contact> map = new HashMap<>();

	public static void main(String[] args) {

		String displayMenu = "[add, list, count, info, delete, search, exit]";

		Scanner input = new Scanner(System.in);

		String choice;
		String name;
		String phone;
		String email;
		String dob;
		String website;
		Integer id;
		Contact newContact;

		File file = new File(
				"C:\\Users\\JonRodriguez-Castill\\OneDrive - Xpanxion\\Desktop\\GitHub\\CodeDevils\\Contacts.txt");

		// reads the object file. Initiates the nextID attribute in contact class to the
		// last object written/read on the file and adds 1.
		// this allows new additions to be added at the end of the list.
		try {
			FileInputStream we = new FileInputStream(file);
			ObjectInputStream ew = new ObjectInputStream(we);

			Contact person = (Contact) ew.readObject();

			while (person != null) {

				map.put(person.getContactId(), person);

				person = (Contact) ew.readObject();

				Contact.nextId = person.getContactId() + 1;
			}

			ew.close();

		}

		catch (EOFException e) {
			System.out.println("Program has read the Object list.");
		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// forever Loop to display menu until user enters "exit"
		while (true) {

			System.out.println(displayMenu);
			choice = input.nextLine();

			// if statement to create a Person or Organization object.

			if (choice.equalsIgnoreCase("add")) {
				System.out.println("Enter Person or Organization:");
				choice = input.nextLine();

				// if statement to create a Person
				if (choice.equalsIgnoreCase("person")) {
					System.out.println("Name: ");
					name = input.nextLine();

					System.out.println("Number: ");
					phone = input.nextLine();

					// if statement to verify phone number format.
					if (!Contact.isValid(phone)) {
						phone = "No Number";
					}

					System.out.println("Email: ");
					email = input.nextLine();

					System.out.println("DOB: ");
					dob = input.nextLine();

					// creates new Person object with user inputed information, and stores it in
					// Hashmap.
					newContact = new Person(name, phone, email, dob);
					map.put(newContact.getContactId(), newContact);

				}

				// if statement to create an Organization
				else if (choice.equalsIgnoreCase("organization")) {

					System.out.println("Name: ");
					name = input.nextLine();

					System.out.println("Number: ");
					phone = input.nextLine();

					// verify phone format.
					if (!Contact.isValid(phone)) {
						phone = "No Number";
					}

					System.out.println("Website: ");
					website = input.nextLine();

					// creates new Organization object and stores it in the HashMap.
					newContact = new Organization(name, phone, website);
					map.put(newContact.getContactId(), newContact);

				}

			}

			// if user chooses list on the main menu enters this codeblock.
			else if (choice.equalsIgnoreCase("list")) {

				// for loop that loops through HashMap entries and prints the Id and Name.
				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
					System.out.println(eachContactMapping.getValue().getContactId() + " : "
							+ eachContactMapping.getValue().getName());
				}

			}

			// if user enters count in the main menu, prints number of contacts within the
			// hash map.
			else if (choice.equalsIgnoreCase("count")) {
				System.out.println(map.size());

			}

			// if user enters info in the main menu, execute code block.
			else if (choice.equalsIgnoreCase("info")) {

				// for loop displaying all objects within the hashmap
				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
					System.out.println(eachContactMapping.getValue());
				}

				try {
					System.out.println("please enter ID: ");

					id = input.nextInt();

					// user will input Id of the person they'd like to retrieve the information.
					// Prints that user info.
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

			// if user enters delete in main menu execute code block.
			else if (choice.equalsIgnoreCase("delete")) {

				// for each loop, looping through entire map by Hash Map entries.
				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {
					System.out.println(eachContactMapping.getValue());
				}

				try {
					System.out.println("Please enter contact ID: ");

					id = input.nextInt();

					// user will input Id of the person they'd like to delete. Program will delete
					// that entry from hash map.
					if (map.containsKey(id)) {
						map.remove(id);

					}

					// for each loop, looping through entire map by Hash Map entries.
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

			// if statement if user enters search in the main menu, executes code block.
			else if (choice.equalsIgnoreCase("search")) {

				System.out.println("Enter your search query");

				choice = input.nextLine().toLowerCase();

				// for each loop that loops through entire Hash Map, gets the Name attribute of
				// the objects within the map, and
				// checks if the map contains user input search query
				for (HashMap.Entry<Integer, Contact> eachContactMapping : map.entrySet()) {

					if (eachContactMapping.getValue().getName().contains(choice)) {
						System.out
								.println(eachContactMapping.getKey() + " : " + eachContactMapping.getValue().getName());
					}

				}
			}

			// if user enters exit at any time exits the loop.
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

		catch (IOException e) {
			System.out.println(e);
		}

		input.close();
 
	}

}

