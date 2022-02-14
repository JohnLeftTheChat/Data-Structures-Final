package binaryTree;
import java.util.*;

public class ExercisesDriver {

	/**
	* Assignment 4: Use stacks to create a customizable sentence
	* @author John Mendiola
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreeWithRank<Integer> BST = new BinarySearchTreeWithRank<Integer>();
	    Scanner in = new Scanner(System.in);
	    String choice = "";
		String hud = "\n"
				+ "insert\n"
				+ "remove\n"
				+ "removeMin\n"
				+ "findMin\n"
				+ "findMax\n"
				+ "findKth\n"
				+ "find\n"
				+ "print\n"
				+ "quit\n\n"
				+ "input an action";

		
		while (!choice.equals("quit")) {
			
			System.out.println(hud);
			choice = in.nextLine();
			if (!isValidInput(choice)) {
				System.out.println("That is not a valid input. Please try again");
				choice = in.nextLine();
			}
			
			int inputValue;
			switch(choice) {
			case "insert": 
				System.out.println("Insert a value:\n");
				inputValue = in.nextInt();
				BST.insert(inputValue);
				System.out.println("Inserted " + BST.findRec(inputValue) + " into the tree\n");
				break;
			case "remove": 
				System.out.println("Input the value that will be removed:\n");
				inputValue = in.nextInt();
				
				// Check to see if value exists
				while (BST.findRec(inputValue) == null) {
					System.out.println(inputValue + " is not in the tree. Please input a number that is in the tree");
					inputValue = in.nextInt();
				}
				BST.remove(inputValue);
				System.out.println("Removed " + inputValue + " from the tree\n");
				break;
			case "removeMin": 
				System.out.println("Removed " + BST.findMinRec() + " from the tree\n");
				BST.removeMin();
				break;
			case "findMin": 
				System.out.println("The smallest number in the tree is " + BST.findMinRec());
				break;
			case "findMax": 
				System.out.println("The largest number in the tree is " + BST.findMaxRec());
				break;
			case "findKth":
				System.out.println("Input a Rank to find the value, with 1 being the smallest value:\n");
				inputValue = in.nextInt();
				break;
			case "find": 
				System.out.println("Input the number that will be searched:\n");
				inputValue = in.nextInt();
				if (BST.findRec(inputValue) != null) {
					System.out.println(inputValue + " was found\n");
				}
				else {
					System.out.println(inputValue + " was not found\n");
				}
				break;
			case "print":
				if (BST.isEmpty()) {
					System.out.println("The tree is empty. Insert variables first");
				}
				else 
					printSubtree(BST.root);
				break;
			}
			choice = in.nextLine();
		}
		System.out.println("Quit the program.");
	}

	/**
	  * Decides if the input is valid
	  * @param cmd the input
	  * @return true if input is a digit specified word, false otherwise 
	  */
	public static boolean isValidInput(String cmd) {
		return (cmd.equals("insert") || cmd.equals("remove") || cmd.equals("removeMin") || cmd.equals("findMin") ||
				cmd.equals("findMax") || cmd.equals("findKth") || cmd.equals("find") || cmd.equals("print") || cmd.equals("quit"));
	}
	
	
	public static void printSubtree(BinaryNode<Integer> t) {
		printSubtreeInternal(t, 0);
	}
	public static void printSubtreeInternal(BinaryNode<Integer> subtree, int createStars) {
		
		// Create stars
		String star = "*";
		String starDepth = "";
		for (int counter = 0; counter < createStars; counter++) {
			starDepth += star;
		}
		
		System.out.println(starDepth + subtree.element);
		if (subtree.right != null) {
			printSubtreeInternal(subtree.right, createStars + 1);
		}
		if (subtree.left != null) {
			printSubtreeInternal(subtree.left, createStars + 1);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
