
public class LRUDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRULinkedCache<Integer, Integer> c = new LRULinkedCache<Integer, Integer>(4);
		c.LRUPut(1, 5);
		System.out.println("cache after calling LRUPUT(1, 5): " + c.toString());
		c.LRUPut(2, 2);
		System.out.println("cache after calling LRUPUT(2, 2): " + c.toString());
		c.LRUPut(3, 7);
		System.out.println("cache after calling LRUPUT(3, 7): " + c.toString());
		c.LRUPut(4, 9);
		System.out.println("cache after calling LRUPUT(4, 9): " + c.toString());
		c.LRUPut(1, 9);
		System.out.println("cache after calling LRUPUT(1, 9): " + c.toString());
		System.out.println("LRUGET(3) returned: " + c.LRUGet(3));
		System.out.println("cache after calling LRUGET(3): " + c.toString());
		c.LRUPut(5, 10);
		System.out.println("cache after calling LRUPUT(5, 10): " + c.toString());
		c.LRUGet(4);
		System.out.println("LRUGET(4) returned: " + c.LRUGet(4));
		System.out.println("cache after calling LRUGet(4): " + c.toString());
		c.LRUGet(10);
		System.out.println("cache after calling LRUGET(10): " + c.toString());
		
	}

}
