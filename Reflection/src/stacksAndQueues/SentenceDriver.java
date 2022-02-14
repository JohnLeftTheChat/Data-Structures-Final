package stacksAndQueues;


import java.util.Scanner;
import java.util.ArrayList;
// Uses ListNode and ListStack java files

/**
* Assignment 4: Use stacks to create a customizable sentence
* @author John Mendiola
*/
public class SentenceDriver {
	
	public static void main(String[] args) {

	    Scanner in = new Scanner(System.in);
		ListStack<String> undo = new ListStack<String>();
	    ListStack<String> redo = new ListStack<String>();
		ArrayList<String> sentence = new ArrayList<String>();
		String cmd = null;
		System.out.println("Give me a sentence");
		String inputSentence = in.nextLine();
		
		// For every space in input sentence, add word to array
		for (String word : inputSentence.split(" ")) {
			sentence.add(word);

		}
		printSentence(sentence);
		
		System.out.println("Please input an operation:\n"
				+ "Choose from add, delete, undo, redo, or print\n"
				+ "If you choose add, please type the word you want right after the command");
		cmd = in.nextLine();
		while (!isValidInput(cmd)) {
			System.out.println("That is not a valid input. Please try again");
			cmd = in.nextLine();
		}
		while (!cmd.equals("quit")) {
			
			// adds the element to the undo stack
			// adds the element to the array
			if (cmd.substring(0, 3).equals("add")) {
				undo.push("add " + cmd.substring(4));
				sentence.add(cmd.substring(4));
			}
			// adds the last element to the undo stack
			// deletes the last element in the array
			else if (cmd.equals("delete")) {
				undo.push("delete " + sentence.get(sentence.size()-1));
				sentence.remove(sentence.size()-1);
			}
			
			// if the last action added an element, add action to redo stack and remove that element 
			// if the last action deleted an element, add action to redo stack and add that element
			else if (cmd.equals("undo")) {
				
				if (!undo.isEmpty()) {
					if (undo.top().substring(0, 3).equals("add")) {
						redo.push("add " + sentence.get(sentence.size()-1));
						sentence.remove(sentence.size()-1);
						
					}
					else if (undo.top().substring(0, 6).equals("delete")) {
						redo.push("delete " + undo.top().substring(7));
						sentence.add(undo.topAndPop().substring(7));
					}
				}
				else
					System.out.println("You haven't done anything yet");
			}
			
			// if the last undo action removed an element, readd the element to the array 
			// if the last undo action added an element, remove the last element from the array
			else if (cmd.equals("redo")) {
				if (!redo.isEmpty()) {
					if (redo.top().substring(0, 3).equals("add")) {
						sentence.add(redo.topAndPop().substring(4));
					}
					else if (redo.top().substring(0, 6).equals("delete")) {
						sentence.remove(sentence.size()-1);
					}
				}
				else 
					System.out.println("You haven't undone anything yet");
			}
			else if (cmd.equals("print")) {
				printSentence(sentence);
			}
		cmd = in.nextLine();
		}
		System.out.println("Quit the program.");
	}
	
	 /**
	  * Prints each word inside the array x
	  * @param x the array containing the sentence
	  */
	public static void printSentence(ArrayList<String> x) {
		System.out.println("The sentence is\n");
		for (int index = 0; index < x.size(); index++) {
			System.out.print(x.get(index) + " ");
		}
		System.out.println("\n");
	}
	
	
	/**
	  * Decides if the input is valid
	  * @param cmd the input
	  * @return true if input equals specified word, false otherwise 
	  */
	public static boolean isValidInput(String cmd) {
		return ((cmd.substring(0, 3).equals("add")) || cmd.equals("delete") || cmd.equals("undo") || cmd.equals("redo") || cmd.equals("print") || cmd.equals("quit"));
		
	}
}
