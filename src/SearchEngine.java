import java.util.Random;

public class SearchEngine {
    private Random rand = new Random();

    public LibraryAddress findAddressForText(String text) {
        // Create a random location based on the text
        String hexId = Integer.toHexString(text.hashCode() & 0xFFFFFF);
        int wall = rand.nextInt(4) + 1;
        int shelf = rand.nextInt(5) + 1;
        int volume = rand.nextInt(32) + 1;
        int page = rand.nextInt(410) + 1;

        // Return the address WITH the search text attached at the end
        return new LibraryAddress(hexId, wall, shelf, volume, page, text);
    }
}