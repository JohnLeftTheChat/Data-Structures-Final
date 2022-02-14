package stacksAndQueues;
import java.util.ArrayList;
import java.util.Scanner;

public class Hints {

	public static void main(String[] args)
    {
		ListStack<String> undo = new ListStack<String>();
	    ListStack<String> redo = new ListStack<String>();
	    
		ArrayList<String> sentence = new ArrayList<String>();
	    Scanner in = new Scanner(System.in);
	    
	    
	    System.out.println("Give me a sentence");
	    
	    // code that populates the sentence (read it from input) goes here.
	    // keep track of a variable that shows where the next word goes (nextWord)
	    System.out.println("Input a command");
	    String cmd = in.next();   // read in the command
	    while (!cmd.equals("quit")) {
	    	/**
	    	 * push the command add and the word on the undo stack
	    	 * make the redo stack completely empty
	    	 * nextWord++
	    	 */
	    	
	    	System.out.println("I did the command.");
	    	in.next();
	    	if(cmd.equals("add")) {
	    		System.out.println("Added the variable");
	    	}
    }
	    
	    
	    
	    	/*
			else if(cmd.equals("delete")){
			    nextWord--;
			    push the command delete and the word on the undo stack;
			    make the redo stack completely empty;
	
			}else if(cmd.equals("undo")){
			    if(!undo.isEmpty()){
				get the action on top of the undo stack;
				if (the action is an add then)
				    delete the word from sentence;
				else if (the action is a delete then)
				    add the word to the sentence;
				
				keep track of the correct nextWord index as you modify the sentence. Increment when adding, decrement when deleting;
				
				redo.push(the action containing the command and the word);
			    }   
	
			}else if(cmd.equals("redo")){
	
			    if( the redo stack is not empty){
				action = redo.topAndPop();
				if (the action is an add then)
				    readd the word to the sentence;
				else if (the action is a delete then)
				    remove the word from the sentence;
	
				keep track of the correct nextWord index;
				
			    }   
			    
			}else if(cmd.equals("print")){
	
			    you know what to do here. 
			}
			*/
	    }
	}

