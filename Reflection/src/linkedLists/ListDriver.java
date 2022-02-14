package linkedLists;



public class ListDriver
{
    public static void main(String [] args)
    {

	LinkedList<Integer> l = new LinkedList<Integer>();
	LinkedList<Integer> l2 = new LinkedList<Integer>();
	
	int i;


	for(i = 0; i < 4; i++)
	    l.listInsert(new Integer(i+3));

	System.out.println("After the first for loop (3,4,5,6)");
	System.out.println("----------------------------------");
	l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.println(n.intValue());
		l.advance();
	}


	l.listHeadInsert(new Integer(500));
	System.out.println("After the head insert(500,3,4,5,6)");
	System.out.println("----------------------------------");
		l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.print(n.intValue() + " ");
		l.advance();
	}


	l.listRemove(new Integer(5));
	System.out.println("After the remove (500,3,4,6)");
	System.out.println("----------------------------------");
	l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.println(n.intValue());
		l.advance();
	}

	while(!l.isAtEnd())
	    l.advance();

	for(i = 1; i < 4; i++)
	    l.listInsert(new Integer(i*100));

	System.out.println("After the inserting (100,200,300) at the end");
	System.out.println("----------------------------------");
	l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.println(n.intValue());
		l.advance();
	}

	l.reset();
	if(l.listSearch(new Integer(200)) != null){
	    System.out.println("\nSearched and found the 200");
	    System.out.println("---------------------------\n");
	}

	l.listInsert(new Integer(150));
	System.out.println("After the inserting 150 before the 200");
	System.out.println("----------------------------------");
	l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.println(n.intValue());
		l.advance();
	}
	
	l2.listInsert(new Integer(500));
	l2.listInsert(new Integer(7));
	l2.listInsert(new Integer(9));
	l2.listInsert(new Integer(200));
	l2.listInsert(new Integer(301));
	
	l.addList(l2);
	

	System.out.println("After the inserting list 2 (500,7,9,200,301)");
	System.out.println("----------------------------------");
	l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.println(n.intValue());
		l.advance();
	}

	
	l2.listRemove(new Integer(9));
	l2.listRemove(new Integer(200));
	
	
	
	
	

	l.subtractList(l2);
	
	
	
	
	System.out.println("After removing list 2 (500,7,301)");
	System.out.println("----------------------------------");
	l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.println(n.intValue());
		l.advance();
	}

	
	l.reverseList();
	System.out.println("After reversing the list");
	System.out.println("----------------------------------");
	l.reset();
	while(!l.isAtEnd())
	    {
		Node<Integer> tmp = l.getCurrent();
		Integer n = tmp.getValue();
		
		System.out.println(n.intValue());
		l.advance();
	}

    }

}