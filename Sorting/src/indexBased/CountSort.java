package indexBased;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
		int[] arr = {23,56,12,9,56,1,45,32,111,24};
		countSort(arr);
		
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void countSort(int[] A) {
		
		int l = A.length;
		int max = Arrays.stream(A).max().getAsInt();
		int[] c = new int[max+1];
		
		for(int i=0; i<l; i++){
			c[A[i]]++;
		}
		
		int i=0, j=0;
		while(i<c.length){
			if(c[i]>0){
				A[j++] = i;
				c[i]--;
			}
			else
				i++;
		}
	}

}
