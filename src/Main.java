import java.util.Scanner;

public class Main {
	
	private static boolean running = true;
	private static Scanner scanner = new Scanner(System.in);
	
	// here are the helper classes
	
	private static LibraryUI ui = new LibraryUI();
	private static SearchEngine search = new SearchEngine();
	
	public static void main(String[] args) {
		System.out.println("_.-'The Library of JAVA'-._"); 
		
		while(running) {
			displayMenu();
			int choice = getUserChoice();
			handleChoice(choice);
		}
		// end that thang
		System.out.println("goodbye!!!");
		scanner.close();
		
	}
	
	public static void displayMenu() {
		System.out.println("\nMain Menu: ");
		System.out.println("1. Navigate to Address.");
		System.out.println("2. Search for text.");
		System.out.println("3. Jump to random page.");
		System.out.println("4. EXIT.");
		System.out.println("Type in selection number: ");
	}
	
	public static int getUserChoice() {
		try {
			return Integer.parseInt(scanner.nextLine());
			
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	public static void handleChoice(int choice) {
		switch(choice) {
		case 1:
			ui.startNavigation();
			break;
		case 2:
			ui.startSearch();
			break;
		case 3:
			ui.jumpToRandom();
			break;
		case 4:
			running = false;
			break;
		default:
			System.out.println("selection not valid!!");
			
		}
	}

}
