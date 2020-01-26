package traversals;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	static int[][] matrix = { {0,0,0,0,0,0,0,0},
							  {0,0,1,1,1,0,0,0},
							  {0,1,0,1,0,0,0,0},
							  {0,1,1,0,1,1,0,0},
							  {0,1,0,1,0,1,0,0},
							  {0,0,0,1,1,0,1,1},
							  {0,0,0,0,0,1,0,0},
							  {0,0,0,0,0,1,0,0} };
	
	static int[] visited = new int[8];
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void traverse(int i){
		queue.add(i);
		System.out.println(i);
		visited[i] = 1;
		while( !queue.isEmpty() ){
			int u = queue.poll();
			for(int v = 1; v < matrix.length; v++){
				if(matrix[u][v] == 1 && visited[v] == 0){
					System.out.println(v);
					visited[v] = 1;
					queue.add(v);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		traverse(4);
	}
}
