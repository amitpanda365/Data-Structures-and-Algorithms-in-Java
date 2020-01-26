package traversals;

import java.util.Stack;

public class DFS {
	
	static int[][] matrix = { {0,0,0,0,0,0,0,0},
							  {0,0,1,1,1,0,0,0},
							  {0,1,0,1,0,0,0,0},
							  {0,1,1,0,1,1,0,0},
							  {0,1,0,1,0,1,0,0},
							  {0,0,0,1,1,0,1,1},
							  {0,0,0,0,0,1,0,0},
							  {0,0,0,0,0,1,0,0} };

	static int[] visited = new int[8];
	static Stack<Integer> stack = new Stack<>();
	
	public static void traverse(int u){
		
		if(visited[u] == 0){
			System.out.println(u);
			visited[u] = 1;
			for(int v = 1; v < matrix.length; v++){
				if(matrix[u][v] == 1 && visited[v] == 0)
					traverse(v);
			}
		}
	}
	
	public static void main(String[] args) {
		traverse(4);
	}

}
