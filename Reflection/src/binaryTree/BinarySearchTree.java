package binaryTree;


//BinaryTreeSearch class
//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void insert( x ) --> Insert x
//void remove( x ) --> Remove x
//void removeMin( ) --> Remove minimum item
//Comparable find( x ) --> Return item that matches x
//Comparable findMin( ) --> Return smallest item
//Comparable findMax( ) --> Return largest item
//boolean isEmpty( ) --> Return true if empty; else false
//void makeEmpty( ) --> Remove all items
//******************ERRORS********************************
//Exceptions are thrown by insert, remove, and removeMin if warranted


public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	public BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root = null;
	}

	public void insert(AnyType x) {
		root = insert(x, root);
	}
	public void remove(AnyType x) {
		root = remove(x, root);
	}
	public void removeMin() {
		root = removeMin(root);
	}
	public AnyType findMin() {
		return elementAt(findMin(root));
	}
	public AnyType findMax() {
		return elementAt(findMax(root));
	}
	public AnyType find(AnyType x) {
		return elementAt(find(x, root));
	}
	public void makeEmpty() {
		root = null;
	}
	public boolean isEmpty() {
		return root == null;
	}

	
	public AnyType findRec(AnyType x) {
		return elementAt(findRec(x, root));
	}
	public AnyType findMinRec() {
		return elementAt(findMinRec(root));
	}
	public AnyType findMaxRec() {
		return elementAt(findMaxRec(root));
	}
	
	/**
	 * Internal method to insert into a subtree
	 * @param x the item to insert
	 * @param t the node that roots the tree
	 * @return the new root 
	 * @throws DuplicateItemException if x is already present 
	 */
	protected BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
		if (t == null)
			t = new BinaryNode<AnyType>( x );
		else if (x.compareTo(t.element) < 0)
			t.left = insert( x, t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = insert( x, t.right);
		else
			System.out.println("There was a exception (DuplicateItemException)");
			//throw new DuplicateItemException(x.toString()); // Duplicate
		return t;
	}
	
	/**
	 * Internal method to remove from a subtree
	 * @param x the item to remove
	 * @param t the node that roots the tree
	 * @return the new root
	 * @throws ItemNotFoundException if x is not found
	 */
	protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
		if (t == null)
			System.out.println("There was a exception (ItemNotFound)");
			//throw new ItemNotFoundException(x.toString());
		if (x.compareTo(t.element) < 0)
			t.left = remove(x, t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) { // Two children
			t.element = findMin(t.right).element;
			t.right = removeMin(t.right);
		}
		else 
			t = (t.left != null) ? t.left : t.right;
			return t;
	}
	
	/**
	 * Internal method to remove minimum item from a subtree
	 * @param t the node that roots the tree
	 * @return the new root 
	 * @throwsItemNotFoundException if t is empty
	 */
	protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> t){
		if (t == null)
			System.out.println("There was a exception (ItemNotFound)");
			//throw new ItemNotFoundException();
		else if (t.left != null) {
			t.left =removeMin(t.left);
			return t;
		}
		return t.right;
	}
	
	/**
	 * Internal method to find the smallest item in a subtree
	 * @param t the node that roots the tree
	 * @return node containing the smallest item
	 */
	protected BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if (t != null) {
			while (t.left != null)
				//findMin(t.left);
				t = t.left;
		}
		return t;
	}
	
	/**
	 * Internal method to find the largest item in a subtree
	 * @param t the node that roots the tree
	 * @return node containing the largest item
	 */
	protected BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if (t != null) {
			while (t.right != null)
				//findMax(t.right);
				t = t.right;
		}
		return t;
	}
	
	/**
	 * Internal method to find an item in a subtree
	 * @param x is item to search for
	 * @param t the node that roots the tree
	 * @return node containing the matched item
	 */
	private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t) {
		while (t != null) {
			if (x.compareTo(t.element) < 0)
				t = t.left;
			else if (x.compareTo(t.element) > 0)
				t = t.right;
			else 
				return t;	// Match
		}
		return null; // Not found
	}
	
	/**
	 * Internal method to get element field
	 * @param t the node
	 * @return the element field or null if t is null
	 */
	private AnyType elementAt(BinaryNode<AnyType> t) {
		return t == null ? null : t.element;
	}
	
	
	
	// ADDED FUNCTIONS ALL BELOW
	
	/**
	 * Created recursive find method
	 * @param root the starting node
	 * @param data the input data
	 * @return the node where the input is located/null if the value was not found
	 */
	private BinaryNode<AnyType> findRec(AnyType data, BinaryNode<AnyType> root){
		while (root != null) {
			if (data.compareTo(root.element) < 0)
				return findRec(data, root.left);
			if (data.compareTo(root.element) > 0)
				return findRec(data, root.right); 
			return root;	// Match
		}
		return null;	// No match
	}
	
	/**
	 * Created recursive method to find the smallest item in a subtree
	 * @param root the starting node
	 * @return the node where the input is located
	 */
	protected BinaryNode<AnyType> findMinRec(BinaryNode<AnyType> root){
			if (root.left == null) {
				return root;
			}
			return findMinRec(root.left);
	}

	/**
	 * Created recursive method to find the largest item in a subtree
	 * @param root the starting node
	 * @return the node where the input is located
	 */
	protected BinaryNode<AnyType> findMaxRec(BinaryNode<AnyType> root){
			if (root.right == null) {
				return root;
			}
			return findMaxRec(root.right);
	}
	
	protected BinaryNode<AnyType> findKthRec(int k, BinaryNode<AnyType> t){
		return null;
	}
	
	/**
	 * Method to print subtree
	 * @param t 
	 */
	public void printSubtree(BinaryNode<Integer> t) {
		printSubtreeInternal(t, 0);
	}
	public void printSubtreeInternal(BinaryNode<Integer> subtree, int createStars) {
		
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
