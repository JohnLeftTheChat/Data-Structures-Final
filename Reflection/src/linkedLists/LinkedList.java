package linkedLists;


//Linked List Class

public class LinkedList<T> {

 
 private Node<T> head;	// head of the list always at the front
 private Node<T> cursor;	// cursor that moves along the one way list


 // constructor
 public LinkedList ()
	{
	    // the first node is not used, dummy node 
	    // so we're always dealing with the element to the right of 
	    // the cursor not what the cursor is pointing to.
	    head = new Node<T>(null, null);
	    cursor = head;
	}

 // if the cursor's next is null, then we're at the end
 public boolean isAtEnd()
 {
	return(cursor.getNext() == null);
 }

 /**
  * Move the cursor to the beginning of the list
  */
 public void reset()
 {
	cursor = head;
 }

 /**
  * Advance the cursor one spot to the right
  */
 public void advance()
 {
	cursor = cursor.getNext();
 }

 /**
  * Return the node to the right of the cursor
  * @return the node to the right of the cursor
  */
 public Node<T> getCurrent()
 {
	return cursor.getNext();
 }

 /**
  * Return the first node in the list
  * @return the first node in the list
  */
 public Node<T> getFirst()
 {
	return head.getNext();
 }

 /**
  * Insert at the beginning of the list, this insert is done to the 
  * right of the dummy node, but to the left of the first meaningful
  * node.
  * @param value the element to be inserted
  */
 public void listHeadInsert(T value)
 {
	head.setNext(new Node<T>(value, head.getNext()));
	
 }

 /**
  * Wherever the cursor is, insert to the right of it, and move the
  * cursor to point to the newly inserted node
  * you may remove the line that advances the cursor, but you need
  * to make sure that you advance the cursor when inserting elements
  * at the end of the list one after another.
  * @param value the element to be inserted
  */
 public void listInsert(T value)
 {
	// insert to the right of the cursor
	cursor.setNext(new Node<T>(value, cursor.getNext()));
																		

	cursor = cursor.getNext();
 }

/**
 * move the cursor to the head of the list, and keep moving it
 * looking for the value, stop if you either find the value
 * or you have reached the end of the list without finding it.
 * return the node that contains the given value back to me.
 * this return will return null if the value is not found.
 * @param value the element to be searched for
 * @return The position where the value is
 */ 
 public Node<T> listSearch(T value)
 {	 
	while(cursor.getNext() != null && 								
	      !cursor.getNext().getValue().equals(value))		
	    cursor = cursor.getNext();								
	
	return cursor.getNext();										
 }


 /**
  * first search (first 4 lines of the code)
  * if you find it (not null) then just remove it by making the
  * cursor's next pointer point to the node next to it's next 
  * pointer (skip a node)
  * @param value the element to be removed 
  */
 public void listRemove(T value)
 {
	reset();
	
	// Find input number
	while(cursor.getNext() != null && 								
	      !cursor.getNext().getValue().equals(value))	
	    cursor = cursor.getNext();								

	if(cursor.getNext() != null)													
		cursor.setNext(cursor.getNext().getNext());		
 }

 /**
  * don't search, just remove the node to the right of the cursor
  * if it's not null
  */
 public void listRemoveCurrent()
 {
	if(cursor.getNext() != null)
		cursor.setNext(cursor.getNext().getNext());
 }

/**
 * Adds the input list to the selected list
 * @param addList the list to be added
 */
 public void addList(LinkedList<T> addList) {
	 addList.reset();
	 this.reset();
	 
	 while (!addList.isAtEnd()) {
		 if (this.listSearch(addList.getCurrent().getValue()) == null)
			 this.listInsert(addList.getCurrent().getValue());
		 addList.advance();
	 }
 }
 

 /**
  * Subtracts the input list from the selected list
  * @param subtractList the list to be subtracted
  */
 public void subtractList(LinkedList<T> subtractList) {
	 subtractList.reset();
	 this.reset();
	 
	 while (!subtractList.isAtEnd() && !this.isAtEnd()) {
		 if (this.listSearch(subtractList.getCurrent().getValue()) != null) {this.listRemoveCurrent();}
		 subtractList.advance(); 
	 }
 }
 
 /**
  * Reverses the elements of the list
  */
 public void reverseList() {
	 LinkedList<T> temp = new LinkedList<T>();
	 this.reset();
	 
	 while(!this.isAtEnd()) {
		 temp.listHeadInsert(cursor.getNext().getValue());
		 this.advance();
	 }
	 if (!temp.isAtEnd()) {cursor.setNext(temp.getCurrent());}
	 
	 head = cursor;
 }
 
 /**
  * Prints the variables in the order of when they were inputed
  * @param inputList the  list to be printed
  */
 public void print(LinkedList<Integer> inputList) {
		while(!inputList.isAtEnd()){
			Node<Integer> tmp = inputList.getCurrent();
			Integer n = tmp.getValue();
			
			System.out.print(n.intValue() + " -> ");
			
			inputList.advance();
	    }	
		System.out.println("\n");
		
	}

 /**
  *
  * @return true if list is empty, false otherwise
  */
public boolean isEmpty() {
	return getFirst() == null;
}
 

/**
 * Makes the list empty
 */
public void makeEmpty() {
	head = new Node<T>(null, null);
}
 
 
 
}