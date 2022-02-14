package hashing;

public class Hash {
	
	// Acceptable hash function
	public int hashPrototype(String key, int tableSize) {
		int hashVal = 0;
		
		for (int i = 0; i < key.length(); i++) 
			hashVal = (hashVal * key.charAt(i)) % tableSize;
		
		return hashVal;
	}
	
	/**
	 * A hash routine for String objects.
	 * @param key the String to hash
	 * @param tableSize the size of the hash table
	 * @return the hash value
	 */
	public int hash(String key, int tableSize) {
		int hashVal = 0;
		
		for (int i = 0; i < key.length(); i++)
			hashVal = 37 * hashVal + key.charAt(i);
		
		hashVal %= tableSize;
		if (hashVal < 0)
			hashVal += tableSize;
		
		return hashVal;
	}

	/**
	 * Another hash routine for String objects.
	 * @param key the String to hash
	 * @param tableSize the size of the hash table
	 * @return the hash value
	 */
	public static int hashString(String key, int tableSize) {
		int index = 0;
		int asciiSum = 0;
		
		// Find sum of ascii 
		for (int i = 0; i < key.length(); i++) {
			char aChar = key.charAt(i);
	        int ascii = aChar;  
	        asciiSum += ascii;			
		}

		// Find index
		index = asciiSum % tableSize;
		System.out.println("The ASCII sum of " + key + " is " + asciiSum + "\nAnd the index is " + index);
		return index;
	}
	
	
	
	
	
	
	
}
