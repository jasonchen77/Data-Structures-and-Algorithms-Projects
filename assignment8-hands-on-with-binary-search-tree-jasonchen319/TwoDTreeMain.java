
public class TwoDTreeMain {

	public static void main(String[] args) {
		System.out.println("building a new tree for nodes");
		TwoDTree tDTree = new TwoDTree();
		tDTree.add(30, 40);
		tDTree.add(5, 25);
		tDTree.add(10, 12);
		tDTree.add(70, 70);
		tDTree.add(50, 30);
		tDTree.add(35, 45);
		System.out.println("level order");
		tDTree.levelOrderPrint();
		System.out.println("contains(5, 25) returned: " + tDTree.contains(5, 25));
		System.out.println("contains(10, 13) returned: " + tDTree.contains(10, 13));
		System.out.println("contains(35, 45) returned: " + tDTree.contains(35, 45));
		System.out.println("building a new tree for nodes");
		tDTree = new TwoDTree();
		tDTree.add(51, 75);
		tDTree.add(25, 40);
		tDTree.add(10, 50);
		tDTree.add(12, 10);
		tDTree.add(5, 90);
		tDTree.add(70, 70);
		tDTree.add(50, 10);
		tDTree.add(4, 1);
		tDTree.add(60, 80);
		System.out.println("level order");
		tDTree.levelOrderPrint();
		System.out.println("contains(51, 75) returned: " + tDTree.contains(51, 75));
		System.out.println("contains(4, 1) returned: " + tDTree.contains(4, 1));
		System.out.println("contains(4, 90) returned: " + tDTree.contains(4, 90));
		System.out.println("add duplicate exception expected");
		tDTree.add(60, 80);
		
		
		
		
		
		
		
	
	
	}

}
