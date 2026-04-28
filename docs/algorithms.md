Algorithm 1: Base-29 Encoding
    Converts a user's string query into a hexadecimal coordinate
    The algorithm treats the 29 characyer alphabet (a,b,c,d... x) and ".", as a base 29 number system.
    mapping each character to its integer value, 0 - 28.
    It multiplies the value by 29^n, [n is the character's position] and adds it to the BigInteger total.
    it then converts the whole thing into base 16 string.

Algorithm 2: Base-29 Decoding
    Unpacks the text inside a hexadecimal coordinate
    essentially the reverse of the algorithm above,
    the hexadecimal id is taken, parsed back into a standard BigInteger, using modulo arithmetic in a while loop, it repeatedly divides the number by 29.|
    The remainder of each devision points towards a character index in the alphabet array.
    The original text is reconstructed character by character.

Algorithm 3: Deterministic Pseudo-Random Seeding
    Fill a searched page [option 2], with random noise , mathmatically locked to the room address.
    the string representation of the LibraryAddress's object is processed through hashCode().
    This generates a completely unique 32 bit integer, in which is passed as the seed of Java's Random class.
    Because we decide the exact outcome of the random function, by providing a direct seed, we guarentee the exact same arrangement of characters every time the room is visited.