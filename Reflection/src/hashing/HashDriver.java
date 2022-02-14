package hashing;
import java.util.*;
public class HashDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		String hashThis = "";
		
		System.out.println("Fuck you, say it back");
		
		hashThis = in.nextLine();
		
		System.out.println("The hash is " + hash(hashThis, 500));
		
	}

	/**
	 * A hash routine for String objects.
	 * @param key the String to hash
	 * @param tableSize the size of the hash table
	 * @return the hash value
	 */
	private static int hash(String key, int tableSize) {
		int hashVal = 0;
		
		for (int i = 0; i < key.length(); i++)
			hashVal = 37 * hashVal + key.charAt(i);
		
		hashVal %= tableSize;
		if (hashVal < 0)
			hashVal += tableSize;
		
		return hashVal;
	}

}
