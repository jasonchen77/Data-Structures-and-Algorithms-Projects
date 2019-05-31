import java.util.*;

public class TwoDTree {
	/*************
	 * attributes
	 ************/

	TwoDTreeNode root;

	/***************
	 * constructor
	 **************/
	TwoDTree() {
		root = null;
	}

	/**********
	 * methods
	 *********/
	/**
	 * To Do: adds a new node with the given x and y coordinates to the TwoDTree
	 * 
	 * @param x
	 * @param y
	 */
	public void add(int x, int y) {
		
		root = add(x, y, root);
	}
	
	protected TwoDTreeNode add(int x, int y, TwoDTreeNode node) {
		if (node == null) {
			// insertion point found; create new node
			node = new TwoDTreeNode(x, y);
		} 
		
		else if ((getLevel(root, node, 1)%2) != 0 && x < node.xCoordinate) {
			node.left = add(x, y, node.left);
		}
		
		else if ((getLevel(root, node, 1)%2) == 0 && y < node.yCoordinate) {
			node.left = add(x, y, node.left);
		}
		
		else if ((getLevel(root, node, 1)%2) != 0 && x > node.xCoordinate) {
			node.right = add(x, y, node.right);
		} 
		
		else if ((getLevel(root, node, 1)%2) == 0 && y > node.yCoordinate) {
			node.right = add(x, y, node.right);
		} 
		
		else if ((getLevel(root, node, 1)%2) != 0 && x == node.xCoordinate && y != node.yCoordinate) {
			node.left = add(x, y, node.left); 
		}
		
		else if ((getLevel(root, node, 1)%2) == 0 && y == node.yCoordinate && x != node.xCoordinate) {
			node.left = add(x, y, node.left); 
		}
		
		else if (x == node.xCoordinate && y == node.yCoordinate){
			// item already exists in this GenericBinarySearchTree
			throw new IllegalArgumentException();
		}
		
		return node;
	}
	
	protected int getLevel(TwoDTreeNode node, TwoDTreeNode levelNode, int level) {
		if (node == null) {
			return 0;
		}
		if (node.xCoordinate == levelNode.xCoordinate && node.yCoordinate == levelNode.yCoordinate) {
			return level;
		}
		int levelAdded = getLevel(node.left, levelNode, level+1);
		if (levelAdded != 0) {
			return levelAdded;
		}
		levelAdded = getLevel(node.right, levelNode, level+1);
		return levelAdded;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @returns true if a node with the given x and y coordinates exist in the
	 *          tree.
	 */
	public boolean contains(int x, int y) {
		TwoDTreeNode node = root;

		// traverse until item found, or it's determined item doesn't exist
		while (node != null) {
			
			if (x == node.xCoordinate && y == node.yCoordinate){
				return true;
			}
			else if ((getLevel(root, node, 1)%2) != 0 && x <= node.xCoordinate) {
				node = node.left;
			}
			
			else if ((getLevel(root, node, 1)%2) == 0 && y <= node.yCoordinate) {
				node = node.left;
			}
			
			else if ((getLevel(root, node, 1)%2) != 0 && x > node.xCoordinate) {
				node = node.right;
			} 
			
			else if ((getLevel(root, node, 1)%2) == 0 && y > node.yCoordinate) {
				node = node.right;
			} 
			
		}
		return false;
	}
	
	

	/**
	 * A method which prints a level order traversal of the tree
	 */
	public void levelOrderPrint() {
		Queue<TwoDTreeNode> queue = new LinkedList<TwoDTreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TwoDTreeNode node = queue.poll();
			System.out.print("(" + node.xCoordinate + "," + node.yCoordinate + ")");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		System.out.println();
	}

	/**
	 * 
	 * 
	 *A nested class encapsulating a node in the TwoDTree
	 */
	private static class TwoDTreeNode {
		/*************
		 * attributes
		 ************/
		int xCoordinate;
		int yCoordinate;
		TwoDTreeNode right;
		TwoDTreeNode left;

		/***************
		 * constructors
		 **************/
		TwoDTreeNode(int x, int y) {
			xCoordinate = x;
			yCoordinate = y;
		}

		TwoDTreeNode(int x, int y, TwoDTreeNode leftChild, TwoDTreeNode rightChild) {
			xCoordinate = x;
			yCoordinate = y;
			left = leftChild;
			right = rightChild;
		}
	}

}
