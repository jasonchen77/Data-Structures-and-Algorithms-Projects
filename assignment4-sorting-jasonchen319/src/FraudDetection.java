
public class FraudDetection {
	
	private final int MIN_SIZE = 5;
	
	public int getNumberOfFrauds(int[] dailyExpeditures, int d) {
		int[] priorDaysExpeditures = new int[d];
		int numberOfFrauds = 0;
		
		if (d >= dailyExpeditures.length) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < dailyExpeditures.length-d; i++) {
			
			int pdeIndex = 0;
			
			for (int j = i; j < i + d; j++) {
				
				priorDaysExpeditures[pdeIndex] = dailyExpeditures[j];
				pdeIndex++;
			}
			quickSort(priorDaysExpeditures, 0, priorDaysExpeditures.length-1);
			double median;
			int midpoint = d / 2;
			if (d % 2 == 0) {
				median = (priorDaysExpeditures[midpoint] + priorDaysExpeditures[midpoint-1])/2.0;	
			}
			else {
				median = priorDaysExpeditures[midpoint];
			}
			int dayTriggerAmount = dailyExpeditures[i + d];
			if (dayTriggerAmount >= 2*median) {
				numberOfFrauds++;
			}
		}
		return numberOfFrauds;
	}
	
	public void quickSort(int[] array, int first, int last) {
		if (last-first+1 < MIN_SIZE) {
			insertionSort(array);
		}
		else {
			int pivotIndex = partition(array, first, last);
			quickSort(array, first, pivotIndex-1);
			quickSort(array, pivotIndex+1, last);
		}
		
	}
	
	public int partition(int[] array, int first, int last) {
		int mid = (first + last)/2;
		if (Integer.compare(array[first], array[mid])> 0){
			swap(array, first, mid);
		}
		
		if (Integer.compare(array[mid], array[last])> 0){
			swap(array, mid, last);
			
			if (Integer.compare(array[first], array[mid])> 0){
				swap(array, first, mid);
			}
		}
		
		swap(array, mid, last-1);
		int pivotIndex = last-1;
		int pivot = array[pivotIndex];
		
		int indexFromLeft = first+1;
		int indexFromRight = last-2;
		boolean done = false;
		while(!done) {
			while (Integer.compare(array[indexFromLeft], pivot) < 0) {
				indexFromLeft++;
			}
			
			while (Integer.compare(array[indexFromRight], pivot) > 0) {
				indexFromRight--;
			}
			
			if (indexFromLeft < indexFromRight) {
				swap(array, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else {
				done = true;
			}
		}
		
		swap(array, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;
		return pivotIndex;
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
				
	}
	
	public static void insertionSort(int[] a) {
		for(int unsorted = 1; unsorted < a.length; unsorted++) {
			int firstUnsorted = a[unsorted];
			insertInOrder(firstUnsorted, a, 0, unsorted-1);
		}
	}
	
	public static void insertInOrder(int entryToInsert, int[] a, int begin, int end) {
		int index = end;
		while((index >= begin) && (entryToInsert < a[index])){
			a[index+1] = a[index];
			index--;
		}
		
		a[index+1] = entryToInsert;
	}

}
