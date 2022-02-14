package stacksAndQueues;

class ListNode<AnyType>
{
      // Constructors
    public ListNode( AnyType theElement )
    {
        this( theElement, null );
    }

    public ListNode( AnyType theElement, ListNode<AnyType> n )
    {
        element = theElement;
        next    = n;
    }

    public AnyType   element;
    public ListNode<AnyType> next;
}
