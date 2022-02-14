package all;
import java.util.*;

import binaryTree.*;
import linkedLists.LinkedList;
import stacksAndQueues.*;
import java.util.ArrayList;
import heap.Heap;
import hashing.*;


/**
 * Everything you have learned in data structures so far.
 * @author SheWentToJareds
 *
 */
public class Driver {
	private static final String menu = "\n\n\tMAIN MENU\n"
			+ "linked - LinkedLists\n"
			+ "stack - Stacks\n"
			+ "queue - Queues\n"
			+ "tree - Binary Tree\n"
			+ "heap - Heap (MIN)\n"
			+ "hash - Hashing\n"
			+ "sort - Sorting\n"
			+ "data - See the stored data\n\n";

	
	private static final String heapMenu = "\n\tMIN HEAP MENU\n\n"
			+ "1 - Add\n"
			+ "2 - Peek\n"
			+ "3 - Remove the Top\n"
			+ "4 - Conduct a Heap Sort\n"
			+ "5 - Import/Export saved Data\n"
			+ "Any other number - Return to Main Menu\n\n";

	private static final String linkedMenu = "\n\tLINKEDLIST MENU\n\n"
			+ "1 - Insert a value\n"
			+ "2 - Remove a value\n"
			+ "3 - Retrieve the first value\n"
			+ "4 - Reverse the list\n"
			+ "5 - Print the list\n"
			+ "6 - Search for a number\n"
			+ "7 - Create a new list\n"
			+ "8 - Switch between lists\n"
			+ "9 - Import/Export saved Data\n"
			+ "Any other number - Return to Main Menu\n\n";
	
	private static final String stackMenu = "\n\tSTACKS MENU\n\n"
			+ "1 - Push\n"
			+ "2 - Pop\n"
			+ "3 - Peek/Top\n"
			+ "4 - Clear\n"
			+ "5 - Import/Export saved data\n"
			+ "Any other number - Return to Main Menu\n\n";
	
	private static final String queueMenu = "\n\tQUEUE MENU\n\n"
			+ "1 - Enqueue\n"
			+ "2 - Dequeue\n"
			+ "3 - First Inserted Number\n"
			+ "4 - Clear"
			+ "5 - Import/Export saved data\n"
			+ "Any other number - Return to Main Menu\n\n";
	
	private static final String treeMenu = "\n\tBINARY TREE MENU\n\n"
			+ "1 - Insert\n"
			+ "2 - Remove\n"
			+ "3 - Find Min/Max\n"
			+ "4 - Remove Min/Max\n"
			+ "5 - Find\n"
			+ "6 - Print\n"
			+ "7 - Balance the tree\n"
			+ "8 - Import/Export Saved Data\n"
			+ "Any other number - Return to Main Menu\n\n";
	
	private static final String hashMenu = "\n\tHASH MENU\n\n"
			+ "1 - Hash String\n"
			+ "2 - Hash Integer\n"
			+ "3 - Go to index\n"
			+ "Any other number - Return to Main Menu\n\n";
	
	private static final String sortMenu = "\n\tSORT MENU\n\n"
			+ "1 - Create or import an array\n"
			+ "2 - Choose a sorting algorithm\t****MUST HAVE EXISTING ARRAY****\n"
			+ "Any other number - Return to Main Menu\n\n";
			
	public static ArrayList<Integer> storedData = new ArrayList<Integer>();

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean repeat = true;
		int input;
		int choice;
		String chosenDataStructure = "";
		
		
		
		

		while (repeat) {

			/*
			 * REMOVE
			 */
			//chosenDataStructure = "SORT";

			
			System.out.println(menu);
			System.out.print("Main>");
			chosenDataStructure = in.next().toUpperCase();
			

			boolean breakout = false;
			switch (chosenDataStructure) {
			default:
				System.out.println("Goodbye");
				repeat = false;
				break;
			
			case "LINKED": // linkedList
				LinkedList<Integer> linkedList = new LinkedList<Integer>();
				
				while (!breakout) {
					// valid input
					System.out.println(linkedMenu);
					System.out.print("Main/Linked>");
					choice  = in.nextInt();
						switch (choice) {
						default:
							breakout = true;
							break;
							
						case 1: // Insert
							System.out.println("Insert a value:\n");
							System.out.print("Main/Linked/Insert>");
							input = in.nextInt();
							linkedList.listInsert(input);
							break;
							
						case 2: // Remove
							System.out.println("Remove which number:\n");
							System.out.print("Main/Linked/Remove>");

							input = in.nextInt();
							linkedList.listRemove(input);
							System.out.println("Removed " + input + " from the list");
							break;
							
						case 3: // Get first
							System.out.println("The first value is " + linkedList.getFirst().getValue());
							break;
							
						case 4: // Reverse
							linkedList.reverseList();
							linkedList.reset();
							System.out.println("The reversed list is\n");
							linkedList.print(linkedList);
							break;
							
						case 5: // Print
							linkedList.reset();
							System.out.println("The list is\n");
							if (linkedList.getFirst() == null)
								System.out.println("empty\n");
							else
								linkedList.print(linkedList);
							break;

						case 6: // Search
							linkedList.reset();
							if (linkedList.getFirst() == null)
								System.out.println("The list is empty. Insert values first\n");
							else {
								System.out.println("What element should be searched:\n");
								System.out.print("Main/Linked/SearchFor>");

								input = in.nextInt();
								if (linkedList.listSearch(input) == null) {
									System.out.println(input + " was not found in the list\n");
								}
								else
									System.out.println(input + " was found\n");
								break;

							}
							break;
							
						case 7: // Create new list
							System.out.println("Create a new list\n");
							
							linkedList.reset();
							break;
							
						case 8: // Switch between list
							System.out.println("Switch to another list\n");
							linkedList.reset();
							break;
							
						case 9: // Import and Export array
							System.out.println("1 - Import Saved array\n"
									+ "2 - Export array\n"
									+ "Default - Return to LinkedList Menu\n\n"
									+ "Enter a number\n");
							System.out.print("Main/Linked/IE>");

							input = in.nextInt();
							switch (input) {
							default:
								break;
							
							/*
							 * ArrayList -> array -> LinkedList
							 */
							case 1:
								System.out.println("The saved array is\n" + storedData.toString() + "\nWould you like to import this array to LinkedList?\n\n"
										+ "1 - Confirm\n"
										+ "Any other number - Return to Linked List Menu\n\n");
								
								if (in.nextInt() == 1) {
									
									// Create and populate array with size of ArrayList
									int[] tmpArray = convertArrayListToArray(storedData);
									
									// import numbers from tmpArray to LinkedList
									linkedList.reset();
									for (int i = 0; i < tmpArray.length; i++) {
										System.out.println("Importing " + tmpArray[i] + " to linkedList");
										linkedList.listInsert(tmpArray[i]); 
									}
									System.out.println("Import success!\n");
								}
								break;

							/*
							 * LinkedList -> array -> ArrayList
							 */
							case 2:
								
								// Create array with size of Linkedlist
								linkedList.reset();
								int index = 0;
								while (!linkedList.isAtEnd()) {
									index++;
									linkedList.advance();
								}
								int[] tmpArray = new int[index];
								
								// Populate array with linkedList elements
								linkedList.reset();
								for (int i = 0; i < tmpArray.length && !linkedList.isAtEnd(); i++, linkedList.advance()) {
									System.out.println("Exporting " + linkedList.getCurrent().getValue() + " to the array");
									tmpArray[i] = linkedList.getCurrent().getValue();
								}
								
								// Populate ArrayList with array elements
								for (int i = 0; i < tmpArray.length; i++) {
									storedData.add(tmpArray[i]);
								}
								System.out.println("Export success!\n");
								break;
							}
					}
					
				}
				break;
				
			case "STACK": // stacks
				System.out.println("You chose Stacks\n");
				ListStack<Integer> stack = new ListStack<Integer>();
				while (!breakout) {
					
					System.out.println(stackMenu);
					System.out.print("Main/Stack>");
					choice  = in.nextInt();
					switch (choice) {
					default: // Exit
						breakout = true;
						break;
						
					case 1:	// Push
						System.out.println("Insert a value:\n");
						input = in.nextInt();
						stack.push(input);
						System.out.println("Inserted " + stack.top() + " onto the stack\n");
						break;
						
					case 2: // Pop
						if (stack.isEmpty()) {
							System.out.println("The stack is empty. There is nothing to remove\n");
							break;
						}
						System.out.println("Are you sure?\n"
								+ "1 - yes\n"
								+ "Any other number - no\n");
						input = in.nextInt();
						if (input == 1) {
							System.out.println(stack.topAndPop() + " was removed from the stack\n");
							break;
						}
						else
							break;
						
					case 3:	// PeekTop
						if (stack.isEmpty()) {
							System.out.println("The stack is empty. Insert a number first\n");
							break;
						}
						else {
							System.out.println("The first element is " + stack.top() + "\n");
							break;
						}
						
					case 4: // Clear list
						if (stack.isEmpty()) {
							System.out.println("The stack is already empty.\n");
							break;
						}
						else {
							stack.makeEmpty();
							System.out.println("The stack has been cleared\n");
							break;
						}
						
					case 5: // Import Export
						System.out.println("1 - Import saved array\n"
								+ "2 - Export to array\n"
								+ "Default - Return to Stack Menu\n\n"
								+ "Enter a number\n");
						System.out.print("Main/Stack/IE>");

						input = in.nextInt();
						switch (input) {
						default:
							break;
						
						/*
						 * ArrayList -> array -> Stack
						 */
						case 1:
							System.out.println("The saved array is\n" + storedData.toString() + "\nWould you like to push this array onto the Stack?\n\n"
									+ "1 - Confirm\n"
									+ "Any other number - Return to Stack Menu\n\n");
							
							if (in.nextInt() == 1) {
								
								// Create and populate array with size of ArrayList
								int[] tmpArray = convertArrayListToArray(storedData);
								
								// import numbers from tmpArray to Stack
								stack.makeEmpty();
								for (int i = 0; i < tmpArray.length; i++) {
									System.out.println("Pushing " + tmpArray[i] + " onto the Stack");
									stack.push(tmpArray[i]); 
								}
								System.out.println("Import success!\n");
							}
							break;
							
						case 2:
							System.out.println("Exporting array\n");
							
							// Create and populate to ArrayList from Stack
							while (!stack.isEmpty()) {
								System.out.println("Popping " + stack.top() + " off the Stack and into the array");
								storedData.add(stack.topAndPop());

							}
							System.out.println("Export success!\n");
							break;
						}
					}
				}
				break;
				
				
			case "QUEUE":
				System.out.println("You chose Queues\n");
				ListQueue<Integer> queue = new ListQueue<Integer>();
				while (!breakout) {
					System.out.println(queueMenu);
					System.out.print("Main/Queue>");
					choice  = in.nextInt();
					switch (choice) {
					default: // Exit
						breakout = true;
						break;
						
					case 1:	// Enqueue
						System.out.println("Insert a value:\n");
						input = in.nextInt();
						queue.enqueue(input);
						System.out.println("Inserted " + input + " into the queue\n");
						break;
					case 2:	// Dequeue
						if (queue.isEmpty()) {
							System.out.println("The queue is empty. There is nothing to dequeue\n");
							break;
						}
						System.out.println("Are you sure?\n"
								+ "1 - yes\n"
								+ "Any other number - no\n");
						if (in.nextInt() == 1) { // Yes
							System.out.println(queue.dequeue() + " was removed from the queue\n");
						}
						break;
						
					case 3:	// Get Front
						System.out.println("The first value inserted was " + queue.getFront() + "\n");
						break;
						
					case 4: // Make empty
						System.out.println("The queue was reset");
						break;
					
					}
				}
				break;
			case "TREE":
				System.out.println("You chose Binary Tree\n");
				BinarySearchTreeWithRank<Integer> tree = new BinarySearchTreeWithRank<Integer>();
				while (!breakout) {

					System.out.println(treeMenu);
					System.out.print("Main/Tree>");
					choice  = in.nextInt();
					switch (choice) {
					default:
						breakout = true;
						break;
						
					case 1:	// Insert
						System.out.println("Insert a value:\n");
						input = in.nextInt();
						tree.insert(input);
						System.out.println("Inserted " + tree.findRec(input) + " into the tree\n");
						break;
						
					case 2:	// Remove
						if (tree.isEmpty()) {
							System.out.println("The tree is empty. There is nothing to remove\n");
							break;
						}
						System.out.println("Remove what number:\n");
						input = in.nextInt();
						if (tree.findRec(input) == null) { // Valid input check
							System.out.println(input + " was not found in the tree\n");
							break;
						}
						else {
							tree.remove(input);
							System.out.println(input + " was removed from the tree\n");
							break;
						}
						
					case 3:	// Find Min/Max
						if (tree.isEmpty()) {
							System.out.println("The tree is empty. There is nothing to remove\n");
							break;
						}
						System.out.println("Min/Max?\n"
								+ "1 - Min\n"
								+ "0 - Max\n");
						input = in.nextInt();
						if (input == 1) {
							System.out.println(tree.findMin() + " was the minimum value\n");
							break;
						}
						else if (input == 0) {
							System.out.println(tree.findMax() + " was the maximum value\n");
							break;
						}
						else {
							System.out.println("Invalid input\n");
							break;
						}
						
					case 4:	// Remove Min/Max
						System.out.println("Remove Min/Max?\n"
								+ "1 - Min\n"
								+ "0 - Max\n");
						input = in.nextInt();
						if (input == 1) {
							System.out.println("The minimum value is " + tree.findMin() + "\n");
							System.out.println("Are you sure you want it removed?\n"
									+ "1 - Yes\n"
									+ "Any other number - No\n");
							input = in.nextInt();
							if (input == 1) {
								tree.remove(tree.findMin());
								System.out.println("Removed\n");
								break;
							}
							else {
								System.out.println("Action aborted\n");
								break;
							}
						}
						else if (input == 0) {
							System.out.println("The maximum value is " + tree.findMax() + "\n");
							System.out.println("Are you sure you want it removed?\n"
									+ "1 - Yes\n");
							input = in.nextInt();
							if (input == 1) {
								tree.remove(tree.findMax());
								System.out.println("Removed\n");
								break;
							}
							else {
								System.out.println("Action aborted\n");
								break;
							}
						}
						else {
							System.out.println("Invalid input\n");
							break;
						}
						
					case 5:	// Find value
						if (tree.isEmpty()) {
							System.out.println("The tree is empty. There is nothing to find\n");
							break;
						}
						
						System.out.println("Search for what value:\n");
						input = in.nextInt();
						if (tree.find(input) == null) {
							System.out.println(input + " was not found\n");
							break;
						}
						else {
							System.out.println(input + " was found\n");
							break;
						}
					case 6:	// Print
						if (tree.isEmpty()) {
							System.out.println("The tree is empty. There is nothing to print\n");
							break;
						}
						else
							tree.printSubtree(tree.root);
						break;

					case 7:	// Balance the tree
						int heightOfLeft =0;
						int heightOfRight =0;
						int balance = heightOfLeft - heightOfRight;
						
						// Traverse the left
						// Traverse the right
						// Find the balance
						
						
						
						
						
					case 8:	// Import Export
						System.out.println("1 - Import Saved array\n"
								+ "2 - Export array\n"
								+ "Default - Return to Binary Tree Menu\n\n"
								+ "Enter a number\n");
						System.out.print("Main/Tree/IE>");

						input = in.nextInt();
					}
				}
				break;
				
				
			case "HEAP":
				System.out.println("You chose Heap\n");
				while (!breakout) {
					// valid input
					System.out.println(heapMenu);
					System.out.print("Main/Heap>");
					choice  = in.nextInt();
					switch (choice) {
					default:	// Exit
						breakout = true;
						break;					
					case 1:	// Add 
						System.out.println("\nInsert what value\n\n");
						System.out.print("Main/Heap/Insert>");
						int insert = in.nextInt();
						Heap.add(insert);
						System.out.println("Inserted " + insert + " into the heap\n");
						break;
					case 2:	// Peek
						System.out.println("The minimum value is " + Heap.peek());
						break;
					case 3:	// Remove
						System.out.println("Removed the minimum value " + Heap.peek());
						Heap.remove();
						break;
					case 4:	// Conduct a heapSort
						
						// Create the sorted array size
						// Return and remove each item in the heap
						int[] sortedArray = new int[Heap.size];
						for (int i = 0; i < sortedArray.length; i++) {
							System.out.println("Removing " + Heap.peek() + " from the heap and adding to the sorted array");
							sortedArray[i] = Heap.remove();
							
						}
						System.out.println("Success! The sorted array is\n");
						for (int i = 0; i < sortedArray.length; i++) {
							System.out.print(sortedArray[i] + " ");
						}
						
						
						break;
					case 5:	// Import Export
						break;
						
					}
				}
			case "HASH":
				System.out.println("You chose Hashing");
				System.out.println("Input the number of indexes\n");
				System.out.print("Main/HashPreRq>");
				String[] hashString = new String[in.nextInt()];
				LinkedList<Integer> bucket = new LinkedList<Integer>();
				
				int numOfItems = 0;
				
				/*
				 * Ratio of number of items stored and the size of the data array is the load factor
				 */
				int loadFactor = numOfItems / hashString.length;
				
				while (!breakout) {
					System.out.println(hashMenu);
					System.out.print("Main/Hash>");
					choice  = in.nextInt();
					switch (choice) {
					default: // Exit
						breakout = true;
						break;
						
					case 1:	// Hash String
						System.out.println("The hash table has " + hashString.length +" slots available");
						System.out.println("Input a word to be hashed\n");
						System.out.print("Main/Hash/String>");
						String hashValue = in.next();
						hashString[Hash.hashString(hashValue, hashString.length)] = hashValue;
						break;
						
					case 2: // Hash Integer
						System.out.println("Option 2\n");
						break;
						
					case 3: // Get value from index
						System.out.println("Input the index to retreive the element\n");
						System.out.print("Main/Hash/GetValue>");
						int index = in.nextInt();
						if (hashString[index] == null) {
							System.out.println("There is nothing at index " + index);
						}
						else {
							System.out.println("The element at index " + index + " is " + hashString[index]);
						}
						break;
					
					}

				}
				break;
				
				
			case "SORT":	// Sorting
				int[] sortThese = {7, 3, 5, 2, 3, 1, 5, 8};
				while (!breakout) {
					System.out.println(sortMenu);
					System.out.print("Main/Sort>");
					input = in.nextInt();
					if (input == 2 && sortThese == null) {
						System.out.println("The array to be sorted is empty. Please import data or create a new array\n");
						System.out.print("Main/Sort>");
						input = in.nextInt();
					}
					switch (input) {
					default:
						breakout = true;
						break;
					case 1:	// Create or Import
						
						if (!storedData.isEmpty()) { // Import
							System.out.println("There is stored data. Do you want to import the data?\nThe array is " + storedData.toString() + "\n\n");
							
							System.out.println(""
									+ "1 - Yes\n"
									+ "Any other number - No\n");
							if (in.nextInt() == 1) {
								for (int i = 0; i < storedData.size(); i++) {
									System.out.println("Importing " + storedData.get(i) + " to the array. . .");
									sortThese = convertArrayListToArray(storedData);
								}
								System.out.println("Success!\n");
								break;
							}
						}
						else { // Create
							ArrayList<Integer> tmp = new ArrayList<Integer>();
							System.out.println("Input numbers to the array. Enter 420 to stop\n");
							input = in.nextInt();
							while (input != 420) {
								System.out.println("Inserted " + input + " into the array");
								tmp.add(input);
								input = in.nextInt();
							}
							sortThese = convertArrayListToArray(tmp);
							break;
						}
						
					case 2: // Convert ArrayList to array and choose a sorting algorithm
						boolean sorted = false;

						// Check for existing array
						if (storedData.isEmpty())
							System.out.println("There is no data in the save\n");
						
						// Convert
						System.out.println("The array to be sorted is\n");
						for (int i = 0; i < sortThese.length; i++)
							System.out.print(sortThese[i] + " ");


						System.out.println("\n\n"
						+ "Choose a sorting procedure\n"
						+ "1 - Insertion\n"
						+ "2 - Selection\n"
						+ "3 - Bubble\n"
						+ "4 - Quick\n"
						+ "5 - Merge\t****UNSTABLE****\n"
						+ "Any other number - Return to Sort Menu\n\n");
						
						System.out.print("Main/Sort/Choose>");
						switch (in.nextInt()) {
						default: 
							break;
						case 1:
							System.out.println("Sorting the array using Insertion Sort. . .");
							insertionSort(sortThese);
							sorted = true;
							break;
						case 2:
							System.out.println("Sorting the array using Selection Sort. . .");
							selectionSort(sortThese);
							sorted = true;
							break;
						case 3:
							System.out.println("Sorting the array using Bubble Sort. . .");
							bubbleSort(sortThese);
							sorted = true;
							break;
						case 4:
							System.out.println("Sorting the array using Quick Sort. . .");
							quickSort(sortThese);
							sorted = true;
							break;
						case 5:
							System.out.println("Sorting the array using Merge Sort. . .");
							//Integer[] specCases = Arrays.stream(sortThese).boxed().toArray(Integer[]::new);
							//mergeSort(specCases);
							mergeSort2(sortThese);
							sorted = true;
							break;
						}
						
						if (sorted) {
							// Print out the sorted array
							System.out.println("Success! The new array is\n");
							for (int i = 0; i < sortThese.length; i++)
								System.out.print(sortThese[i] + " ");
							
							// Export
							System.out.println("\n\nExport to Saved Data?\n"
									+ "1 - Yes\n"
									+ "Any other number - Return to Main Menu\n");
							System.out.print("Main/Sort/Successful>");
							if (in.nextInt() == 1) {
								// Array -> ArrayList
								for (int i = 0; i < sortThese.length; i++) {
									storedData.add(sortThese[i]);
									System.out.println("Exporting " + sortThese[i] + " to the save");
								}
								System.out.println("Export success!\n");	
							}
							break;
						}
						else
							break;
					}
				}
				
				
			case "DATA":
				int[] tmpArray = convertArrayListToArray(storedData);
				if (storedData.isEmpty()) {
					System.out.println("There is no data in the array\n");
					break;
				}
				
				// ArrayList -> array
				
				System.out.println("The saved array is\n");
				for (int i = 0; i < tmpArray.length; i++) {
					System.out.print(tmpArray[i] + " ");
				}
				
				
				breakout = true;
				break;
			}
		}
	}
	
	
	
	
	
	public static int[] heapSort(int[] items) {
		if (items.length == 0) {
			System.out.println("There are no items in the heap!\n");			
		}
		else {
			int[] sorted = new int[items.length];
			for (int i = 0; i < sorted.length; i++) {
			}
		}
		return items;
	}

	/**
	 * Instead of swapping items, shift to the right
	 * @param array to be sorted
	 */
	public static void insertionSort(int[] array){
		
		// Walk through array
		for (int indexI = 0; indexI < array.length - 1; indexI++) {
			int current = array[indexI];
			int indexJ = indexI - 1;
			
			// While cursor is not at end, and element is greater than cursor index
			// Shift element to the right 
			while (indexJ >= 0 && array[indexJ] > current) {
				array[indexJ + 1] = array[indexJ];
				indexJ--;
			}
			// Insert the current element
			array[indexJ + 1] = current;
		}
		
	}
	
	/**
	 * Set first element as minIndex, compare with second element, compare with third element, etc. 
	 *  place minIndex in front of unsorted list. Index starts at first unsorted element
	 * @param array the array to be sorted
	 */
	public static void selectionSort(int[] array) {
		
		// Walk through array
		for (int index = 0; index < array.length - 1; index++) {
			int minIndex = index; // Set first position as a minimum
			
			// Find the smallest element by comparing with the element in the minIndex
			for (int j = index + 1; j < array.length; j++) {
				
				// Update min when finding a smaller element
				if (array[j] < array[minIndex])
					minIndex = j;
			}
			// Put the smallest element at the cursor
			swap(array, index, minIndex);
		}
	}
	
	/**
	 * (Inefficient algorithm) - 
	 * Until array is sorted, walk through the array
	 * and swap elements out of order
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
	
	public static void mergeSort2(int[] array) {
		int[] tmp = new int[array.length];
		mergeSortInternal(array, tmp, 0, array.length - 1);
	}
	private static void mergeSortInternal(int[] array, int[] tmp, int leftStart, int rightEnd) {
		if (leftStart < rightEnd) { // will stop only when both the left and right half of the array are the same value
			int mid = (leftStart + rightEnd) / 2;
			mergeSortInternal(array, tmp, leftStart, mid); // Left half of array
			mergeSortInternal(array, tmp, mid + 1, rightEnd); // Right half of array
			merge(array, tmp, leftStart, mid + 1, rightEnd);
		}
	}
	private static void merge(int[] array, int[] tmp, int leftIndex, int rightIndex, int rightEnd) {
		int leftEnd = rightIndex - 1;
		int tmpIndex = leftIndex; // tmp index starts at left 
		int size = rightEnd - leftIndex + 1;
		
		// At this point neither left or right is empty
		while (leftIndex <= leftEnd && rightIndex <= rightEnd) { 	// Check to see if either indexes have crossed over their array
			if (array[leftIndex] <= array[rightIndex])
				tmp[tmpIndex++] = array[leftIndex++];				// If leftIndex < rightIndex, tmpIndex = leftIndex. Increment both
			else
				tmp[tmpIndex++] = array[rightIndex++];				// If leftIndex > rightIndex, tmpIndex = rightIndex. Increment both
		}
		
		// At this point either left or right is empty
		while (leftIndex <= leftEnd)
			tmp[tmpIndex++] = array[leftIndex++];					// Copy the rest of leftIndex to tmpIndex. Increment both
		while (rightIndex <= rightEnd)
			tmp[tmpIndex++] = array[rightIndex++];					// Copy the rest of rightIndex to tmpIndex. Increment both
		
		// Copy tmp to original array
		for (int i = 0; i < tmp.length; i++, rightEnd--)
			array[rightEnd] = tmp[rightEnd];
	}

	
	
	
	/**
	 * Mergesort algorithm
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
		T[] tmpArray = (T[]) new Comparable[array.length];
		mergeSort(array, tmpArray, 0, array.length - 1);
	}
	/**
	 * Internal method that makes recursive calls, which halves the arrays
	 * @param array an array of integers 
	 * @param tmpArray array to place the merged result (UNUSED)
	 * @param low the left-most index of the subarray
	 * @param high the right-most index of the subarray
	 */
	private static <T extends Comparable<? super T>> void mergeSort(T[] array, T[] tmpArray, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(array, tmpArray, low, mid);	// Sort from left to center
			mergeSort(array, tmpArray, mid + 1, high);	// Sort from center to right
			merge(array, tmpArray, low, mid + 1, high); // merge left and right 
		}
	}
	/**
	 * Internal method that merges two sorted halves of a subarray into tmpArray
	 * @param array an array of integers
	 * @param tmpArray array to place the merged result (USED)
	 * @param leftStart the left-most index of the subarray
	 * @param rightStart the index of the start of the second half
	 * @param rightEnd the right-most index of the subarray
	 */
	private static <T extends Comparable<? super T>> void merge(T[] array, T[] tmpArray, int leftStart, int rightStart, int rightEnd) {
		int leftEnd = rightStart - 1;
		int tmpPos = leftStart;
		int totalElements = rightEnd - leftStart + 1;
		
		// Main loop
		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			if (array[leftStart].compareTo(array[rightStart]) <= 0)
				tmpArray[tmpPos++] = array[leftStart++];
			else
				tmpArray[tmpPos++] = array[rightStart++];
		}
		
		// Loops for remaining elements in either halves
		// To be completed AFTER the either one of the lists is completed
		while (leftStart <= leftEnd)	// Copy rest of left half
			tmpArray[tmpPos++] = array[leftStart++];
		while (rightStart <= rightEnd)	// Copy rest of right half
			tmpArray[tmpPos++] = array[rightStart++];
		
		// Copy tmpArray back to original array
		for (int counter = 0; counter < totalElements; counter++, rightEnd--)
			array[rightEnd] = tmpArray[rightEnd];
	}
	
	/**
	 * Quicksort algorithm (driver) 
	 * @param array the array to be sorted
	 */
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	private static void quickSort(int[] array, int leftIndex, int rightIndex) {
		 if (leftIndex >= rightIndex)
			 return;
		 int pivot = array[(leftIndex + rightIndex) / 2];
		 System.out.println("The pivot is " + pivot);
		 int index = partition(array, pivot, leftIndex, rightIndex);
		 
		 quickSort(array, leftIndex, index - 1);
		 quickSort(array, index, rightIndex);
		 
	}
	private static int partition(int[] array, int pivot, int leftIndex, int rightIndex) {
		while (leftIndex < rightIndex) {
			
			// Increment low while low < pivot
			// Decrement high while high > pivot
			// Swap high and low
			while (array[leftIndex] < pivot)
				leftIndex++;
			while (array[rightIndex] > pivot)
				rightIndex--;
			if (leftIndex <= rightIndex) {
				System.out.println("Swapping " + array[leftIndex] + " with " + array[rightIndex]);
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;	
			}
		}
		return leftIndex;
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
	
	public static boolean validInput() {
		return false;
		
	}
	
    private static int[] convertArrayListToArray(ArrayList<Integer> storedData) {
    	 
        //if ArrayList is null, return empty array
        if(storedData == null)
            return new int[0];
        
        /*
         * Create array having same size
         * as ArrayList
         */
        int[] newArray = new int[storedData.size()];
        
        /*
         * Iterate ArrayList and assign
         * individual elements to array
         */
        for(int i = 0; i < storedData.size(); i++)
        	newArray[i] = storedData.get(i);
        
        return newArray;
    }	

    
}
