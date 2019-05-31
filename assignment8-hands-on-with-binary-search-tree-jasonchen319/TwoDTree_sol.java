
import java.util.*;
public class TwoDTree_sol {
	/*************
	 * attributes
	 ************/
	
	TwoDTreeNode root;

	/***************
	 * constructor
	 **************/
	TwoDTree_sol()
	{
		root = null;
	}
	
	/**********
	 * methods
	 *********/
	
	public void add(int x, int y)
	{
		root=addNode(x,y,root,0);
	}
	
	public TwoDTreeNode addNode(int x, int y, TwoDTreeNode node, int level)
	{
		//Stopping Condition: check to see if the root is null  and add the new node to the root
		if (node == null)
		{	node= new TwoDTreeNode(x,y,null,null);
			return node;
		}
		
		//IF the node is duplicate then throw an error
		if (x==node.xCoordinate && y==node.yCoordinate)
			throw new IllegalArgumentException ("cannot add duplicate item to the tree");
		
		/*
		 * If level is even and x is less than the root's x coordinate or if level is odd and y is less than root's y coordinate
		 * call the add method recursively on the root's left child and increment the level
		 */
		
		if ((level % 2 ==0 && x<=node.xCoordinate)|| (level%2==1 && y<=node.yCoordinate))
				node.left = addNode(x,y,node.left,level+1);
		
		/*
		 *Else if level is even and x is greater than the root's x coordinate or if level is odd and y is greater than root's y coordinate
		 * call the add method recursively on the root's right child and increment the level
		 */
		else if ((level % 2 ==0 && x>node.xCoordinate)|| (level%2==1 && y>node.yCoordinate))
				node.right = addNode(x,y,node.right,level+1);
		return node;			
	
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @returns true if a node with the given x and y coordinates exist in the tree.
	 */
	public boolean contains(int x, int y)
	{
		return findNode(x,y)!=null?true:false;
	}
	
	private TwoDTreeNode findNode(int x, int y)
	{
		TwoDTreeNode node=root;
		int level=0;
		while(node!=null)
		{
			if (node.xCoordinate==x && node.yCoordinate==y )
				return node;
			if((level%2==0 && x<=node.xCoordinate) || (level%2==1 && y<=node.yCoordinate) )
				node = node.left;
			else if((level%2==0 && x>node.xCoordinate) || (level%2==1 && y>node.yCoordinate) )
				node = node.right;
			level++;
		}
			return null;
	}
	
		public void levelOrderPrint()
	{
		Queue<TwoDTreeNode> queue= new LinkedList<TwoDTreeNode>();
		queue.add(root);
		while (!queue.isEmpty())
		{	
			TwoDTreeNode node = queue.poll();
			System.out.print("("+node.xCoordinate+ ","+node.yCoordinate+")");
			if (node.left !=null)
				queue.add(node.left);
			if (node.right!=null)
				queue.add(node.right);
		}
	}
private static class TwoDTreeNode
{
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
	TwoDTreeNode(int x, int y)
	{
		xCoordinate=x;
		yCoordinate=y;
	}
	
	TwoDTreeNode(int x, int y, TwoDTreeNode leftChild, TwoDTreeNode rightChild)
	{
		xCoordinate=x;
		yCoordinate=y;
		left = leftChild;
		right=rightChild;
	}
}


public static void main(String[] args){
	System.out.println("building a new tree for nodes (30,40)(5,25)(10,12),(70,70),(50,30),(35,40)");
	TwoDTree_sol tDTree = new TwoDTree_sol();
	tDTree.add(30,40);
	tDTree.add(30, 50);
	tDTree.add(5,25);
	tDTree.add(10,12);
	tDTree.add(70,70);
	tDTree.add(50,30);
	tDTree.add(35,45);
	System.out.println("level order traversal for this tree is:");
	tDTree.levelOrderPrint();
	System.out.println("contains(5,25) returned: " + tDTree.contains(5,25) );
	System.out.println("contains(10,13) returned: " +tDTree.contains(10,13) );
	System.out.println("contains(35,45) returned: " +tDTree.contains(35,45) );
	//System.out.println("minx: "+ tDTree.getMinX());

	System.out.println("building a new tree for nodes (51,75)(25,40)(10,50),(12,10),(5,90),(70,70)(50,10)(4,1)(60,80)");
	tDTree = new TwoDTree_sol();
	tDTree.add(51,75);
	tDTree.add(25,40);
	tDTree.add(10,50);
	tDTree.add(12,10);
	tDTree.add(5,90);
	tDTree.add(70,70);
	tDTree.add(50,10);
	tDTree.add(4,1);
	tDTree.add(60,80);
	System.out.println("level order traversal for this tree is:");
	tDTree.levelOrderPrint();
//	System.out.println("minx: "+ tDTree.getMinX());

	System.out.println("contains(51,75) returned: " + tDTree.contains(51,75) );
	System.out.println("contains(4,1) returned: " +tDTree.contains(4,1) );
	System.out.println("contains(4,90) returned: " +tDTree.contains(4,90) );
	System.out.println("Trying to add duplicate item, exception is expected");
	tDTree.add(60,80);

}


	
}