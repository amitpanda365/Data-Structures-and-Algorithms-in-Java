package comparisionBased.NlogN;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] arr = {23,56,12,9,56,1,45,32,111,24,Integer.MAX_VALUE};
		quickSort(arr,0,arr.length-1);
		
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void quickSort(int[] arr, int l, int h) {
		int j;
		System.out.println(l+" "+h);
		if(l < h){
			j = partition(arr,l,h);
			quickSort(arr,l,j);
			quickSort(arr,j+1,h);
		}
	}
	
	private static int partition(int[] arr, int l, int h){
		
		int pivot = arr[l];
		int i = l, j = h;
		
		do{
			do{
				i++;
			}while(arr[i] <= pivot);
			
			do{
				j--;
			}while(arr[j] > pivot);
			
			if(i < j){
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}while(i<j);
		
		int t = arr[l];
		arr[l] = arr[j];
		arr[j] = t;
		return j;
	}

}
