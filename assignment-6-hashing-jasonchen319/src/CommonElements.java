import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommonElements {

	
	public static <T> List<T> findCommonElements(List<List<T>> collections){
		HashMap<T, Integer> tempHM = new HashMap<T, Integer>();
		HashMap<T, Integer> tempHM2 = new HashMap<T, Integer>();
		List<T> results = new ArrayList<T>();

		for(T i:collections.get(0)) {
			if (tempHM.containsKey(i)) {
				tempHM.put(i, tempHM.get(i)+1);
			}
			tempHM.put(i, 1);
		}
		
		for(List<T> list:collections) {
			for(T item:list) {
				if(tempHM.containsKey(item)) {
					if (tempHM2.containsKey(item)) {
						tempHM2.put(item, tempHM2.get(item)+1);
					}
					else {
						tempHM2.put(item, 1);
					}
				}
			}
			tempHM = tempHM2;
			tempHM2 = new HashMap<T, Integer>();

		}
		
		Iterator ite = tempHM.entrySet().iterator();
		while (ite.hasNext()) {
			Map.Entry<T, Integer> entry = (Map.Entry<T, Integer>)ite.next();
			for (int i = 0; i < entry.getValue(); i++) {
				results.add(entry.getKey());
			}
		}
		
		return results;
		
	}
}

