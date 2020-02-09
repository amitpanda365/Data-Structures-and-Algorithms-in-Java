package minCostSpanningTree;

import java.util.Arrays;
import java.util.Scanner;

public class KruskalsAlgorithm {

	static int[] set;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter");
		int e = 9;
		int v = 7;
		int[][] edges = new int[3][e];

		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int cost = sc.nextInt();
			edges[0][i] = v1;
			edges[1][i] = v2;
			edges[2][i] = cost;
		}

		sc.close();

		set = new int[v + 1];
		Arrays.fill(set, -1);

		int[] included = new int[e];

		int[][] minCostTree = new int[2][v - 1];

		int min, k, x, y;
		int i = 0;
		while (i < v - 1) {

			min = edges[2][0];
			k = 0;
			for (int j = 1; j < e; j++) {
				if (included[j] == 0 && edges[2][j] < min) {
					min = edges[2][j];
					k = j;
				}
			}

			x = edges[0][k];
			y = edges[1][k];

			if ((find(x) != find(y)) || (find(x) == -1 && find(y) == -1)) {

				union(find(x), find(y));
				minCostTree[0][i] = x;
				minCostTree[1][i] = y;
				i++;

			}

			included[k] = 1;
		}

		for (i = 0; i < v - 1; i++) {
			System.out.println(minCostTree[0][i] + " " + minCostTree[1][i]);
		}

	}

	private static void union(int x, int y) {
		if (x < y) {
			set[x] = set[x] + set[y];
			set[y] = x;
		} else {
			set[y] = set[x] + set[y];
			set[x] = y;
		}
	}

	private static int find(int v) {
		while (set[v] > 0)
			v = set[v];
		return v;
	}

}
