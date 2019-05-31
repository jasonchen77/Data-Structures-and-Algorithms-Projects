import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElememtsDriver {

	public static void main(String[] args) {
		
		List<List<Integer>>collections =new ArrayList<List<Integer>>();
		collections.add(0,
		new ArrayList<Integer>(Arrays.asList(3, 4,3,3, 9, 8,9, 12, 15, 7, 13)));
		collections.add(1,
		new ArrayList<Integer>(Arrays.asList(15,24,3,3,50,12,39,9,9)));
		collections.add(2,
		new ArrayList<Integer>(Arrays.asList(78,65,24,3,3,9,13,9,3,12)));
		collections.add(3, new
		ArrayList<Integer>(Arrays.asList(15,78,14,9,3,2,3,3,9,44,12)));
		//CommonElements ce = new CommonElements();
		List<Integer> result = CommonElements.findCommonElements(collections);
		
		for(int i:result) {
			System.out.println(i);
		}

	}

}
