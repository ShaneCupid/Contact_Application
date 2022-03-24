import java.util.HashMap;
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
		Integer num = 1;

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

					map.put(num, new Person(name, phone, email, dob));
					num++;

				} else if (choice.equalsIgnoreCase("organization")) {

					System.out.println("Name: ");
					name = input.nextLine();

					System.out.println("Number: ");
					phone = input.nextLine();

					if (!Contact.isValid(phone)) {
						phone = "No Number";
					}

					System.out.println("Website: ");
					website = input.nextLine();

					map.put(num, new Organization(name, phone, website));
					num++;
				}

			} else if (choice.equalsIgnoreCase("list")) {

				for (int i = 1; i <= map.size(); i++) {
					System.out.println(map.get(i).getContactId() + " : " + map.get(i).getName());
				
				}

			} else if (choice.equalsIgnoreCase("count")) {
				System.out.println(map.size());

			} else if (choice.equalsIgnoreCase("info")) {

				for (int i = 1; i <= map.size(); i++) {
					System.out.println(map.get(i));
				}

				try {
				System.out.println("please enter ID: ");
				id = input.nextInt();

				if (map.get(id).getContactId() == id) {
					System.out.println(map.get(id));
				}
				
				}
				
				catch(NullPointerException e) {
					
					System.out.println(e.getStackTrace());
				}
			} else if (choice.equalsIgnoreCase("delete")) {
				
				for (int i = 1; i <= map.size(); i++) {
					System.out.println(map.get(i));
				}

				System.out.println("Please enter contact ID: ");
				id = input.nextInt();

				if (map.containsKey(id)) {
					map.remove(id);
					
				}
				System.out.println(map);
			} else if (choice.equalsIgnoreCase("search")) {
				
				System.out.println("Enter your search query");
				
				choice=input.nextLine();
				
				for (int i = 1; i <= map.size(); i++) {
					
					if(map.get(i).getName().contains(choice)) {
						System.out.println(map.get(i).getContactId() + " : " + map.get(i).getName());
					}
				}
				
				
			}
			if (choice.equalsIgnoreCase("exit")) {
				break;
			}
		}
		System.out.println("Thanks for using our PhoneBook");

		input.close();
	}

}
