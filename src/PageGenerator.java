import java.util.Random;

public class PageGenerator {
	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz, .";
	private final int PAGE_SIZE = 3200; // 40 lines * 80 characters
	
	public String generatePageText(LibraryAddress address) {
		// make a seed  oout of the given info, combine address parts
		//turn address into a String, use hashcode as Long
		long seed = (address.toString()).hashCode();
		
		// make a random oject with the seed.
		
		Random random = new Random(seed);
		
		// build the page by the character
		StringBuilder pageContent = new StringBuilder();
		
		for (int i = 0; i < PAGE_SIZE; i++) {
			// pick random index  from alphabet
			int charIndex = random.nextInt(ALPHABET.length());
			char nextChar = ALPHABET.charAt(charIndex);
			
			pageContent.append(nextChar);
		}
		return pageContent.toString();
	}
}
