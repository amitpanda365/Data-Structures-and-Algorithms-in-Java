package comparisionBased.NSquare;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {23,56,12,9,56,1,45,32,111,24};
		bubbleSort(arr);
		
		for(int i : arr)
			System.out.print(i+" ");

	}

	private static void bubbleSort(int[] arr) {
		
		int l = arr.length;
		int flag ;
		for(int i=0; i<l; i++){
			flag = 0;
			for(int j=0; j<l-1-i; j++){
				if(arr[j] > arr[j+1]){
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
					flag = 1;
				}
			}
			if(flag == 0)
				break;
		}
	}

}
