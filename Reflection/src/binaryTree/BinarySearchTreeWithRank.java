package binaryTree;


//BinarySearchTreeWithRank class
//
//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//Comparable findKth(k)--> Return kth smallest item
//All other operations are inherited
//******************ERRORS********************************
//IllegalArgumentException thrown if k is out of bounds

public class BinarySearchTreeWithRank<AnyType extends Comparable<? super AnyType>> 
					extends BinarySearchTree<AnyType>
{
	public static class BinaryNodeWithSize<AnyType> extends BinaryNode<AnyType>{
		int size;
		BinaryNodeWithSize(AnyType x){
			super(x);
			size = 0;
		}
	}

	/**
	 * Find the kth smallest item in the tree
	 * @param k the desired rank (1 is the smallest item)
	 * @return the kth smallest item in the tree
	 * @throws IllegalArgumentException if k is less
	 * than 1 or more than the size of the subtree
	 */
	public AnyType findKth(int k) {
		return findKth(k, root).element;
	}
	
	/**
	 * Internal method to find kth smallest item in a subtree
	 * @param k the desired rank (1 is the smallest item)
	 * @return Node containing the kth smallest item in the subtree
	 * @throws IllegalArgumentException if k is less
	 * than 1 or more than the size of the subtree
	 */
	protected BinaryNode<AnyType> findKth(int k, BinaryNode<AnyType> t) {
		if (t == null)
			throw new IllegalArgumentException();
		
		/*
		 * Computes the size of the left subtree
		 * If the left subtree exists, find the size
		 * if not, the size is 0
		 */
		int leftSize = (t.left != null) ? ((BinaryNodeWithSize<AnyType>) t.left).size : 0;
		
		if (k < leftSize)
			return findKth(k, t.left);
		if (k == leftSize + 1)
			return t;
		return findKth(k - leftSize - 1, t.right);
	}
	
	
	/**
	 * Internal method to insert into a subtree
	 * @param x the item to insert
	 * @param tt the node that roots the tree
	 * @return the new root
	 */
	protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> tt) {
		BinaryNodeWithSize<AnyType> t = (BinaryNodeWithSize<AnyType>) tt;
		
		if (t == null)
			t = new BinaryNodeWithSize<AnyType>(x);
		else if (x.compareTo(t.element) < 0)
			t.left = insert(x,t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = insert( x, t.right);
		else 
			System.out.println("Crashed");
			//throw new DuplicateItemException(x.toString());
		t.size++;
		return t;
	}
	

	protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> tt) {
		BinaryNodeWithSize<AnyType> t = (BinaryNodeWithSize<AnyType>) tt;
		
		if (t == null)
			System.out.println("Crashed");
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
			return (t.left != null) ? t.left : t.right;
		
		t.size--;
		return t;
	}
	
	/**
	 * Internal method to remove the smallest item from a subtree,
	 * adjusting size fields as appropriate
	 * @param t the node that roots the tree
	 * @return the new root
	 */
	protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> tt) {
		BinaryNodeWithSize<AnyType> t = (BinaryNodeWithSize<AnyType>) tt;
		
		if (t == null)
			System.out.println("Crashed");
			//throw new ItemNotFoundException();
		if (t.left == null)
			return t.right;
		
		t.left = removeMin(t.left);
		t.size--;
		return t;
	}
	
	/**
	 * Rotate binary tree node with left child. 
	 * For AVL trees, this is a single rotation
	 * @param root the start of the subtree
	 * @return The rotated root Node
	 */
	protected BinaryNode<AnyType> rotateWithLeftChild(BinaryNode<AnyType> root){
		BinaryNode<AnyType> newParent = root.left;
		root.left = newParent.right;
		newParent.right = root;
		return newParent;
	}
	
	/**
	 * Rotate binary tree node with right child. 
	 * For AVL trees, this is a single rotation
	 * @param root the start of the subtree
	 * @return The rotated root Node
	 */
	protected BinaryNode<AnyType> rotateWithRightChild(BinaryNode<AnyType> root){
		BinaryNode<AnyType> newParent = root.right;
		root.right = newParent.left;
		newParent.left = root;
		return newParent;
	}
	
	/**
	 * Double rotate binary tree node: first left child with its right child,
	 * then k1 with new left child.
	 * For AVL trees, this is a double rotation 
	 * @param k1 the start of the subtree
	 * @return The double rotated root Node
	 */
	protected BinaryNode<AnyType> doubleRotateWithLeftChild(BinaryNode<AnyType> k1){
		k1.left = rotateWithRightChild(k1.left);
		return rotateWithLeftChild(k1);
	}
	
	/**
	 * Double rotate binary tree node: first right child with its left child, 
	 * then node k1 with new right child.
	 * For AVL trees, this is a double rotation
	 * @param k1 the start of the subtree
	 * @return The double rotated root Node
	 */
	protected BinaryNode<AnyType> doubleRotateWithRightChild(BinaryNode<AnyType> k1){
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	
	
	
}

