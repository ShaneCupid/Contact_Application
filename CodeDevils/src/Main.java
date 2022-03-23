import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		HashMap<Integer, Contact> map = new HashMap<>();

		String displayMenu = "[add, list, count, info, delete, search, exit]";
		Scanner input = new Scanner(System.in);
		String choice;
		String name;
		String phone = null;
		String email;
		String dob;
		String website;
		Integer id;
		Integer num = 0;

		while (true) {
			System.out.println(displayMenu);
			choice = input.nextLine();

			if (choice.equalsIgnoreCase("add")) {
				System.out.println("");
				choice = input.nextLine();

				if (choice.equalsIgnoreCase("person")) {
					System.out.println("name");
					name = input.nextLine();

					System.out.println("number");
					phone = input.nextLine();

					if (!Contact.isValid(phone)) {
						phone = "No Number";
					}

					System.out.println("email");
					email = input.nextLine();

					System.out.println("DOB");
					dob = input.nextLine();

					map.put(num, new Person(name, phone, email, dob));
					num++;

				} else if (choice.equalsIgnoreCase("organization")) {

					System.out.println("name");
					name = input.nextLine();

					System.out.println("number");
					phone = input.nextLine();

					if (!Contact.isValid(phone)) {
						phone = "No Number";
					}

					System.out.println("website");
					website = input.nextLine();

					map.put(num, new Organization(name, phone, website));
					num++;
				}


			} else if (choice.equalsIgnoreCase("list")) {

				for(int i = 0; i<=map.size()-1;i++ ) {
					System.out.println(map.get(i).getContactId() + " : " + map.get(i).getName());

				}

			} else if (choice.equalsIgnoreCase("count")) {
				System.out.println(map.size());


			} else if (choice.equalsIgnoreCase("info")) {

				for(int i = 0; i<=map.size()-1;i++ ) {
					System.out.println(map);
				}
				
                 System.out.println("please enter ID: ");
                 id =input.nextInt();
                 
                 if(map.get(id).getContactId() == id) {
                	 System.out.println(map.get(id)); 
                 }
                 

			} else if (choice.equalsIgnoreCase("delete")) { 
				for(int i = 0; i<=map.size()-1;i++ ) {
					System.out.println(map);
				}
				
				System.out.println("Please enter contact ID: ");
				id = input.nextInt();
				
				if (map.containsKey(id)) {
					map.remove(id);
				}

			} else if (choice.equalsIgnoreCase("search")) {
				System.out.println();
			} 
			if (choice.equalsIgnoreCase("exit")) {
				break;
			}
		} 
		System.out.println("Thanks for using our PhoneBook");

		input.close();
	}
	

	static void delete() {

	}

	static void search() {

	}

	static void info() {

	}


}

