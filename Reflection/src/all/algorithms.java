package all;

public class algorithms {
	
	public static void test() {
		System.out.println("hello world");
	}
	/**
	 * (Inefficient algorithm) - 
	 * As long as array is unsorted, keep walking through the array
	 * and swap elements
	 * @param sortArray 
	 */
	public static void bubbleSort(int[] sortArray) {
		boolean isSorted = false;
		int lastUnsorted = sortArray.length - 1;
		
		// While array unsorted
		while (!isSorted) {
			isSorted = true;
			
			// Walk through array
			for (int i = 0; i < sortArray.length - 1; i++) {
				
				// If elements are out of order, swap
				if (sortArray[i] > sortArray[i + 1]) {
					swap(sortArray, i, i + 1);
					isSorted = false;
				}
			}
			lastUnsorted--;
		}
	}
	
	/**
	 * Set first element as minIndex, compare with second element, compare with third element, etc. 
	 *  place minIndex in front of unsorted list. Index starts at first unsorted element
	 * @param array the array to be sorted
	 */
	public static void selectionSort(int[] array) {
		
		// Walk through array
		for (int cursor = 0; cursor < array.length - 1; cursor++) {
			int minIndex = cursor; // Set first position as a minimum
			
			// Find the smallest element by comparing with the element in the minIndex
			for (int j = cursor + 1; j < array.length; j++) {
				
				// Update min when finding a smaller element
				if (array[j] < array[minIndex])
					minIndex = j;
			}
			// Put the smallest element at the cursor
			swap(array, cursor, minIndex);
		}
	}
	
	/**
	 * Instead of swapping items, shift to the right
	 * @param array to be sorted
	 */
	public static void insertionSort(int[] array){
		
		// Walk through array
		for (int i = 0; i < array.length - 1; i++) {
			int current = array[i];
			int j = i - 1;
			
			// While cursor is not at end, and element is greater than cursor index
			// Shift element to the right 
			while (j >= 0 && array[j] > current) {
				array[j + 1] = array[j];
				j--;
			}
			// Insert the current element
			array[j + 1] = current;
		}
		
	}
	
	/**
	 * Swap element I with element J
	 * @param array the input array
	 * @param indexI the index to be swapped with J
	 * @param indexJ the index to be swapped with I
	 */
	public static void swap(int[] array, int indexI, int indexJ) {
		int tmp = array[indexI];
		array[indexI] = array[indexJ];
		array[indexJ] = tmp;
	}

}
