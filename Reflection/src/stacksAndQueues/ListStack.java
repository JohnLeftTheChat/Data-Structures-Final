package stacksAndQueues;
import java.nio.BufferUnderflowException;

//ListStack class
//
//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void push( x )         --> Insert x
//void pop( )            --> Remove most recently inserted item
//AnyType top( )         --> Return most recently inserted item
//AnyType topAndPop( )   --> Return and remove most recent item
//boolean isEmpty( )     --> Return true if empty; else false
//void makeEmpty( )      --> Remove all items
//******************ERRORS********************************
//top, pop, or topAndPop on empty stack

/**
* List-based implementation of the stack.
* @author Mark Allen Weiss
*/
public class ListStack<AnyType>
{
	 private ListNode<AnyType> topOfStack;
 /**
  * Construct the stack.
  * Height is null
  */
	 public ListStack( )
	 {
	     topOfStack = null;
	 }

 /**
  * Test if the stack is logically empty.
  * @return true if empty, false otherwise.
  */
	 public boolean isEmpty( )
	 {
	     return topOfStack == null;
	 }

 /**
  * Make the stack logically empty.
  */
	 public void makeEmpty( )
	 {
	     topOfStack = null;
	 }

 /**
  * Insert a new item into the stack.
  * @param x the item to insert.
  */
	 public void push( AnyType x )
	 {
	     topOfStack = new ListNode<AnyType>( x, topOfStack );
	 }

 /**
  * Remove the most recently inserted item from the stack.
  * @throws UnderflowException if the stack is empty.
  */
	 public void pop( )
	 {
	     if(isEmpty())
	         throw new BufferUnderflowException();
	     topOfStack = topOfStack.next;
	 }

 /**
  * Get the most recently inserted item in the stack.
  * Does not alter the stack.
  * @return the most recently inserted item in the stack.
  * @throws UnderflowException if the stack is empty.
  */
	 public AnyType top( )
	 {
	     if( isEmpty( ) )
	         throw new BufferUnderflowException( );
	     return topOfStack.element;
	 }

 /**
  * Return and remove the most recently inserted item
  * from the stack.
  * @return the most recently inserted item in the stack.
  * @throws UnderflowException if the stack is empty.
  */
	 public AnyType topAndPop( )
	 {
	     if( isEmpty( ) )
	         throw new BufferUnderflowException( );
	
	     AnyType topItem = topOfStack.element;	// top
	     topOfStack = topOfStack.next;	// pop
	     return topItem;
	 }
}