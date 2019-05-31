
public class FraudDetectionDriver {

	public static void main(String[] args) {

		FraudDetection fd = new FraudDetection();
		int[] a = {2,1,4,5,6};
		//fd.quickSort(a, 0, 11);
		int[] b = {4,3,2,2,3,6,8,9,10};
		int num = fd.getNumberOfFrauds(b, 5);
		System.out.print(num);
		for(int i=0; i< a.length; i++) {
			//System.out.println(a[i]);
		}
	}

}
