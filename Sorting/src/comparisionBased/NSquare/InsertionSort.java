package comparisionBased.NSquare;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {23,56,12,9,56,1,45,32,111,24};
		insertionSort(arr);
		
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void insertionSort(int[] arr) {
		
		int n = arr.length;
		int i, j, x ;
		
		for(i=1; i<n; i++) {
			
			j = i-1;
			x = arr[i];
			
			while(j>-1 && arr[j] > x)
				arr[j+1] = arr[j--];
			
			arr[j+1] = x;
		}
	}

}
