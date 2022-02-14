package heap;

import java.util.Arrays;

/*
 * Minimum Integer Heap
 */
public class Heap {
	private static int capacity = 10;
	public static int size = 0;
	
	static int[] items = new int[capacity];
	

	
	/**
	 * Gets the location of the Left Child
	 * @param parentIndex the root to begin from
	 * @return The value of the Left child
	 */
	private static int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	/**
	 * Gets the location of the Right Child
	 * @param parentIndex the root to begin from
	 * @return The value of the right child
	 */
	private static int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	/**
	 * Gets the location of the Parent
	 * @param parentIndex the root to begin from
	 * @return The value of the parent
	 */
	private static int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	/**
	 * Check if Left child exists
	 * @param index the root to begin  from
	 * @return true if there is a left child, false otherwise
	 */
	private static boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	/**
	 * Check if Right child exists
	 * @param index the root to begin  from
	 * @return true if there is a right child, false otherwise
	 */
	private static boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	/**
	 * Check if Parent exists
	 * @param index the root to begin  from
	 * @return true if there is a parent, false otherwise
	 */
	private static boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	/**
	 * Gets the value of the left child
	 * @param index the root to begin from
	 * @return the value of the left child
	 */
	private static int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	/**
	 * Gets the value of the right child
	 * @param index the root to begin from
	 * @return the value of the right child
	 */
	private static int rightChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	/**
	 * Gets the value of the parent
	 * @param index the root to begin from
	 * @return the value of the parent
	 */
	private static int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	/**
	 * If the heap is full, double capacity and copy the elements
	 */
	private static void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	/**
	 * Returns the first element in the array
	 * @return the root of the heap
	 */
	public static int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}
	
	/**
	 * Returns and removes the first element in the array. 
	 * Decrease the size, then ReHeapify
	 * @return the root of the heap
	 */
	public static int remove() {
		if (size == 0)
			throw new IllegalStateException();
		
		int item = items[0];
		
		/*
		 * Removes the first element in the array
		 * Moves the last element the first index
		 * Adjust the heap to fit Heap Property
		 */
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;				
	}
	
	/**
	 * Adds an element to the last index of the array.
	 * ReHeapify
	 * @param item the element to be added
	 */
	public static void add(int item) {
		ensureExtraCapacity();
		
		
		items[size] = item;
		size++;
		heapifyUp(); // Must maintain the Heap Property
	}
	
	/**
	 * Start from last index and work up.
	 * Swap elements that do not obey Heap Property
	 */
	public static void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	/**
	 * Start from first index and work down.
	 * Swap elements that do not obey Heap Property
	 */
	public static void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if (items[index] < items[smallerChildIndex])
				break;
			else
				swap(index, smallerChildIndex);
			index = smallerChildIndex;
		}
				
	}
	
	/**
	 * Swap element I with element J
	 * @param array the input array
	 * @param indexI the index to be swapped with J
	 * @param indexJ the index to be swapped with I
	 */
	public static void swap(int indexOne, int indexTwo) {
		int tmp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = tmp;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
