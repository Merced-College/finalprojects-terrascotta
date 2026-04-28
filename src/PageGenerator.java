import java.math.BigInteger;
import java.util.Random;

public class PageGenerator {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz, .";
    private final int PAGE_SIZE = 3200; 
    
    public String generatePageText(LibraryAddress address) {
        BigInteger base = BigInteger.valueOf(29);
        BigInteger value;

        // 1. DECODE THE MATH: Read the Hex ID and turn it back into a number
        try {
            value = new BigInteger(address.getHexagonId(), 16);
        } catch (NumberFormatException e) {
            value = BigInteger.ZERO; // Fallback if user types a bad Hex ID manually
        }

        StringBuilder decodedText = new StringBuilder();
        if (value.equals(BigInteger.ZERO)) {
            decodedText.append(ALPHABET.charAt(0));
        }

        // Unpack the number back into Base-29 letters
        while (value.compareTo(BigInteger.ZERO) > 0) {
            int charVal = value.remainder(base).intValue();
            decodedText.insert(0, ALPHABET.charAt(charVal)); // Insert at front to reverse it properly
            value = value.divide(base);
        }

        // 2. FILL THE PAGE: The Hex ID defines the start of the page. 
        // We use the address as a seed to deterministically generate the remaining noise.
        long paddingSeed = address.toString().hashCode();
        Random random = new Random(paddingSeed);
        
        StringBuilder finalPage = new StringBuilder(decodedText);
        while (finalPage.length() < PAGE_SIZE) {
            finalPage.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return finalPage.toString();
    }
}