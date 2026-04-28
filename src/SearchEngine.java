// handles the logic of converting user input into a LibraryAddress, which is then used to generate the page content. The conversion uses a base-29 encoding of the input text to create a unique Hex ID for the address, and random values for the wall, shelf, volume, and page number.

import java.math.BigInteger;
import java.util.Random;

public class SearchEngine {

    public LibraryAddress findAddressForText(String text) {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz, .";
        BigInteger base = BigInteger.valueOf(29);
        BigInteger value = BigInteger.ZERO;

        // Turn the text into a massive Base-29 number
        for (int i = 0; i < text.length(); i++) {
            int charVal = ALPHABET.indexOf(text.charAt(i));
            value = value.multiply(base).add(BigInteger.valueOf(charVal));
        }

        // The Hex ID literally IS the math representation of the word
        String hexId = value.toString(16);

        // Assign random wall/shelf/vol for the rest of the address
        Random r = new Random();
        return new LibraryAddress(hexId, r.nextInt(4)+1, r.nextInt(5)+1, r.nextInt(32)+1, r.nextInt(410)+1);
    }

    //biginteger conversion aided by gemini ai
}