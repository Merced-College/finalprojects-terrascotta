import java.util.Scanner;
import java.util.Random;
public class LibraryUI {
	private Scanner scanner = new Scanner(System.in);
	private PageGenerator generator = new PageGenerator();
	
	public void startNavigation() {
		System.out.println("\n-- Enter Library Coordinates ---");
		
		System.out.print("Hexagon ID: ");
		String hex = scanner.nextLine();
		
		System.out.print("Wall (1 - 4): ");
		int w = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Shelf (1 - 5): ");
		int s = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Volume (1 - 32): ");
		int v = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Page (1 - 410): ");
		int p = Integer.parseInt(scanner.nextLine());
		
		// create address object
		LibraryAddress address = new LibraryAddress(hex,w,s,v,p);
		
		// generate stuff
		String content = generator.generatePageText(address);
		
		// draw
		System.out.println("\nLocation: " + address.toString());
		displayFormattedPage(content);	
	}
	
	private void displayFormatted
	
}
