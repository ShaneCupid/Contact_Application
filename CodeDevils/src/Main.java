import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//HashMap<Integer, String> map = new HashMap<>();
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		String displayMenu = "[add, list, count, info, delete, search, exit]";
		Scanner input = new Scanner(System.in);
		String choice;
		
		
		do {
			System.out.println(displayMenu);
			choice = input.nextLine();
			
			if (choice.equalsIgnoreCase("add")) {
				
				if (choice.equalsIgnoreCase("person")) {
					
				} else if (choice.equalsIgnoreCase("organization")) {
					
				}
				
			} else if (choice.equalsIgnoreCase("list")) {
				System.out.println();
				
			} else if (choice.equalsIgnoreCase("count")) {
				System.out.println();
				
			} else if (choice.equalsIgnoreCase("info")) {
				System.out.println();
			
			} else if (choice.equalsIgnoreCase("delete")) { 
				System.out.println();
				System.out.println();
				
			} else if (choice.equalsIgnoreCase("search")) {
				
			} 
			
		} while (choice.equalsIgnoreCase("exit"));
			
 	}
}
