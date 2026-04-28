import java.util.Scanner;
import java.util.Random;
import java.util.Stack; // DATA STRUCTURE #1: Stack for history

public class LibraryUI {
    private Scanner scanner = new Scanner(System.in);
    private PageGenerator generator = new PageGenerator();
    private Stack<LibraryAddress> history = new Stack<>(); 
    private SearchEngine search = new SearchEngine();
    
    public void startNavigation() {
        System.out.println("\n--- Enter Library Coordinates ---");
        System.out.print("Hexagon ID (Text/Number): ");
        String hex = scanner.nextLine();
        
        // Simple input handling for coordinates
        System.out.print("Wall (1-4): ");
        int w = Integer.parseInt(scanner.nextLine());
        System.out.print("Shelf (1-5): ");
        int s = Integer.parseInt(scanner.nextLine());
        System.out.print("Volume (1-32): ");
        int v = Integer.parseInt(scanner.nextLine());
        System.out.print("Page (1-410): ");
        int p = Integer.parseInt(scanner.nextLine());

        LibraryAddress address = new LibraryAddress(hex, w, s, v, p);
        navigateTo(address);
    }

    private void navigateTo(LibraryAddress address) {
        history.push(address); // Track where we've been
        String content = generator.generatePageText(address);
        System.out.println("\nLocation: " + address.toString());
        displayFormattedPage(content);
    }

    // ALGORITHM #1: Formatting logic using DATA STRUCTURE #2: 2D Array
    private void displayFormattedPage(String content) {
        int rows = 40;
        int cols = 80;
        char[][] grid = new char[rows][cols];
        int charPtr = 0;

        System.out.println("--------------------------------------------------------------------------------");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (charPtr < content.length()) {
                    grid[r][c] = content.charAt(charPtr++);
                }
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void startSearch() {
    System.out.print("\nEnter text to search for: ");
    String query = scanner.nextLine().toLowerCase();
    
    // Validate the input (only letters/commas/periods/spaces)
    if (!query.matches("[a-z, .]+")) {
        System.out.println("Error: The library only contains lowercase letters, spaces, commas, and periods.");
        return;
    }

    System.out.println("Calculating the precise coordinates...");
    LibraryAddress foundAt = search.findAddressForText(query);
    
    System.out.println("Result: Found!");
    System.out.println("Location: " + foundAt.toString());
    
    System.out.print("Would you like to navigate there now? (y/n): ");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
        navigateTo(foundAt);
    }
}

    // ALGORITHM #2: Random Generation Logic
    public void jumpToRandom() {
        Random r = new Random();
        String randomHex = Integer.toHexString(r.nextInt(0xFFFFFF));
        LibraryAddress randomAddr = new LibraryAddress(
            randomHex, 
            r.nextInt(4) + 1, 
            r.nextInt(5) + 1, 
            r.nextInt(32) + 1, 
            r.nextInt(410) + 1
        );
        navigateTo(randomAddr);
    }
}