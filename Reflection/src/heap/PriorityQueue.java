package heap;

import java.util.*;


/**
 * PriorityQueue class implemented via the binary heap
 * @author SheWentToJareds
 *
 */


/*
 * Can only delete the root node
 * 1. Swap the root and the last element
 * 2. Decrement the array size
 * 3. Compare the root, right, and left child to find the largest element
 * 4. Swap the root with the largest of the two
 * O(log2n)
 * 
 * Heap Property:
 * 1. Complete Binary Tree
 * 2. Every element is larger than its children
 */
public class PriorityQueue<AnyType> extends AbstractCollection<AnyType> implements Queue<AnyType> {

	private int currentSize; 	// Number of elements in the heap
	private AnyType[] array; 	// The heap array
	private Comparator<? super AnyType> cmp;
	private static final int DEFAULT_CAPACITY = 100;
	
	/**
	 * Construct an empty PriorityQueue.
	 */
	public PriorityQueue() {
		currentSize = 0;
		cmp = null;
		array = (AnyType[]) new Object[DEFAULT_CAPACITY + 1];
	}
	/**
	 * Construct an empty PriorityQueue with a specified comparator.
	 */
	public PriorityQueue(Comparator<? super AnyType> c) {
		currentSize = 0;
		cmp = c;
		array = (AnyType[]) new Object[DEFAULT_CAPACITY + 1];
	}
	/**
	 * Construct a PriorityQueue from another Collection
	 */
	public PriorityQueue(Collection<? extends AnyType> coll) {
		cmp = null;
		currentSize = coll.size();
		array = (AnyType[]) new Object[(currentSize + 2) * 11 / 10];
		
		int i = 1;
		for (AnyType item : coll)
			array[i++] = item;
		buildHeap();
	}
	
	
	public int size() {
		return currentSize;
	}
	public void clear() {
		currentSize = 0;				
	}
	public Iterator<AnyType> iterator(){
		// See online code
		return null;
	}
	
	/**
	 * Returns the smallest item in the priority queue
	 * @return the smallest item
	 * @throws NoSuchElementException if empty
	 */
	public AnyType element() {
		if (isEmpty())
			throw new NoSuchElementException();
		return array[1];
	}
	
	public boolean add(AnyType x) {
		if (currentSize + 1 == array.length)
			doubleArray();
			
			// Percolate up
		int hole = ++currentSize;
		array[0] = x;
		
		for (; compare(x, array[hole / 2]) < 0; hole / 2)
			array[hole] = array[hole /2];
		array[hole] = x;
		return true;
		
	}
	
	
	
	
	
	
}
