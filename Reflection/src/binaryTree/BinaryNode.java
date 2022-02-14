package binaryTree;

//Basic node stored in unbalanced binary search trees
//Note that this class is not accessible outside
//this package

public class BinaryNode<AnyType> {
	// Constructor
	BinaryNode(AnyType theElement){
		element = theElement;
		left = right = null;
	}
	
	// Data, accessible by other package routines
	AnyType element;
	BinaryNode<AnyType> left;
	BinaryNode<AnyType> right;
}