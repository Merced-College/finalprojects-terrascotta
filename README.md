Jessie Alcalan
4-28-26

The Library of Java

This project aims to make a theoretical infinite "library". this library is made of of a hex code, wall, shelf, volume, and page, in whcih are provided by the user.

Using this info, the library quickly coordinates the EXACT contents of the location.

Simply put, it's like if I asked you to check this specific area in the library, at this wall, this shelf, this volume, and this specific page, and read its contents out loud. 

The result will never be different for a specific area, the math is done at the moment, as long as the input is the same, the contents will always be the same.

-------------------------

We are now given the option to see if a specific string, like "Kathleen", is at the start of a page.

Using an admittedly complex and innefficient process, a Base-29 Encoding algorithm 
(29 because of the possibility of different letters and punctuation)
we can take in the query, fully encode it into base 29 using BigInteger in order to compress into a single hex id

passing that hex id into a "new Random()" guarentees a page with the first letters being the query


if you are feeling lucky, maybe you can find the string you're lookign for manually by navigating towards random pages, great luck trying to find "egret" naturally.
----------------------
The program is ran by simply running the Main.java

The program allows the user to:
    1. navigate to a specific address
    2. search for a specific string
    3. jump to a random area in the library
    4. terminate

This project actively uses 3 data structures, the Stack, the 3D Array, and StringBuilder

Algorithm 1: Base-29 Encoding
O(N)
Algorithm 2: Base-29 Decoding
O(N2)
Algorithm 3: Deterministic Pseudo-Random Seeding
O(1)

I encountered a problem with a communication bewteen the search engine and the page generator, i was getting dull responses when i looked for a string, a rewrite of the page generator was needed

using a stringbuilder to append the decompressed base 29 ad reversing the output proved to save a lot of time

for version 2, i could interpret the base 29 values visually, as an image, a canvas.
