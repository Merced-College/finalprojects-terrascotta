import java.util.Random;

public class PageGenerator {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz, .";
    private final int PAGE_SIZE = 3200; 
    
    public String generatePageText(LibraryAddress address) {
        long seed = (address.toString()).hashCode();
        Random random = new Random(seed);
        StringBuilder pageContent = new StringBuilder();
        
        // 1. Fill page with random characters
        for (int i = 0; i < PAGE_SIZE; i++) {
            int charIndex = random.nextInt(ALPHABET.length());
            pageContent.append(ALPHABET.charAt(charIndex));
        }

        // 2. INJECTION: If this address has a search word, stamp it in
        String query = address.getSearchQuery();
        if (query != null && !query.isEmpty()) {
            // Find a random spot to insert the word where it fits
            int maxInsertPosition = PAGE_SIZE - query.length();
            int insertPos = random.nextInt(maxInsertPosition);
            
            // Overwrite the random characters with the search word
            pageContent.replace(insertPos, insertPos + query.length(), query);
        }
        
        return pageContent.toString();
    }
}