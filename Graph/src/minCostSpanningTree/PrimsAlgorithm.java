package minCostSpanningTree;

import java.util.Arrays;

public class PrimsAlgorithm {

	static final int I = Integer.MAX_VALUE;

	static int[][] graph = { 	{ I, I, I, I, I, I, I, I },
								{ I, I, 13, I, I, I, 4, I },
								{ I, 13, I, 11, I, I, I, 25 },
								{ I, I, 11, I, 10, I, I, I },
								{ I, I, I, 10, I, 12, I, 9 },
								{ I, I, I, I, 12, I, 14, 7 },
								{ I, 4, I, I, I, 14, I, I },
								{ I, I, 25, I, 9, 7, I, I } };
	
	static int[][] spanningTree = new int[2][6];
	static int[] near = new int[8];

	public static void main(String[] args) {
		
		int n = 7;
		int i, j=0, k=I, u=-1, v=-1;
		int min = I;
		for(i = 1; i <= n; i++){
			for(j = i; j <= n; j++){
				if(graph[i][j] < min){
					min = graph[i][j];
					u = i;
					v = j;
				}
			}
		}
		
		Arrays.fill(near, I);
		
		spanningTree[0][0] = u;
		spanningTree[1][0] = v;
		near[u] = 0;
		near[v] = 0;
		
		
		for(i = 1; i <= n; i++){
			if(near[i] != 0)
				near[i] = graph[i][u] < graph[i][v] ? u : v;
		}
		for(i = 1; i < 6; i++){
			
			min = I;
			for(j = 1; j < near.length; j++){
				if(near[j] != 0 && graph[j][near[j]] < min){
					min = graph[j][near[j]];
					k = j;
				}
			}
			
			spanningTree[0][i] = k;
			spanningTree[1][i] = near[k];
			near[k] = 0;
			
			for( j = 1; j < near.length; j++){
				if(near[j] != 0 && graph[j][k] < graph[j][near[j]]){
					near[j] = k;;
				}
			}
		}
		
		int minCost = 0;
		for(i = 0; i < 6; i++){
			System.out.println(spanningTree[0][i]+" "+spanningTree[1][i]);
			minCost += graph[spanningTree[0][i]][spanningTree[1][i]];
		}
		
		System.out.println(minCost);

	}

}
