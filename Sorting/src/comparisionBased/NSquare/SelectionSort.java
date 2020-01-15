package comparisionBased.NSquare;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {23,56,12,9,56,1,45,32,111,24};
		selectionSort(arr);
		
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void selectionSort(int[] arr) {
		int i, j, k;
		int n = arr.length;
		for(i = 0; i < n-1; i++){
			for(j = k = i; j < n; j++){
				if(arr[k] > arr[j])
					k = j;
			}
			int t = arr[k];
			arr[k] = arr[i];
			arr[i] = t;
		}
	}

}
