package comparisionBased.NlogN;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] A = {23,22,12,9,58,1,45,77,82,98,53,21};
		//mergeSort(A);
		mergeSort(A,0,A.length-1);
		
		for(int i : A)
			System.out.print(i+" ");
	}

	private static void mergeSort(int[] A, int l, int h) {
		
		if(l < h){
			int mid = (l+h)/2;
			mergeSort(A,l,mid);
			mergeSort(A,mid+1,h);
			merge(A,l,mid,h);
		}
		
	}

	private static void mergeSort(int[] a) {
		
		int l,mid,h,p;
		
		int n = a.length-1;
		
		for(p=2; p<=n; p*=2){
			
			for(int i=0; i<n; i= i+p){
				l=i;
				h=Integer.min(i+p-1,n);
				mid=(l+h)/2;
				merge(a,l,mid,h);
			}
		}
		
		p = p/2;
		if(p <= n)
			merge(a,0,p-1,n);
			
		
	}
	
	private static void merge(int[] A, int l, int mid, int h){
		
		int i,j,k;
		i = k = l;
		j = mid+1;
		int[] B = new int[h+1];
		
		while(i <= mid && j <= h){
			
			if(A[i] < A[j])
				B[k++] = A[i++];
			else
				B[k++] = A[j++];
		}
		
		for(;i <= mid; i++)
			B[k++] = A[i];
		
		for(;j <= h; j++)
			B[k++] = A[j];
		
		for(i = l; i <= h; i++){
			A[i] = B[i];
		}
	}

}
