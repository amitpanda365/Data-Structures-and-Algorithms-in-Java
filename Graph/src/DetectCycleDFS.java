package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDFS {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,3}};
        if(isCyclic(edges))
            System.out.println("Cycle found");
        else System.out.println("Cycle not found");
    }

    private static boolean isCyclic(int[][] edges) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length+1;
        for(int i=1; i<=n+1; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] e : edges){
            int x = e[0];
            int y = e[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int[] isVisited = new int[n+1];
        return dfs(adj, isVisited, 1, -1);
    }

    private static boolean dfs(List<ArrayList<Integer>> adj, int[] isVisited, int node, int parent){
        isVisited[node] = 1;
        for(int i : adj.get(node)){
            if(isVisited[i] == 0) {
                if(dfs(adj, isVisited, i, node))
                    return true;
            }
            else if(i != parent){
                System.out.println(i+" "+parent);
                return true;
            }
        }
        return false;
    }
}
