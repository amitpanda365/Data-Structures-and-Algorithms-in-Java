package indexBased;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = { 23, 56, 312, 9, 1256, 10000, 1, 445, 932, 93, 24 }; // 23,56,12,9,56,1,45,32,93,24
		radixSort(arr);

		for (int i : arr)
			System.out.print(i + " ");
	}

	private static void radixSort(int[] A) {

		int max = Arrays.stream(A).max().getAsInt();
		Queue<Integer>[] radix = new Queue[10];
		int i, j, x;
		for (i = 0; i < radix.length; i++) {
			radix[i] = new LinkedList<>();
		}

		for (int p = 1; p <= max; p *= 10) {

			for (i = 0; i < A.length; i++) {
				x = (A[i] / p) % 10;
				radix[x].add(A[i]);
			}

			i = j = 0;

			while (i < 10) {
				if (radix[i].size() > 0) 
					A[j++] = radix[i].poll();
				else
					i++;
			}

		}

	}

}
