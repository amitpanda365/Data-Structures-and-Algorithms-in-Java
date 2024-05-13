package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleBFS {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5},{4,6},{4,7}};
        if(isCyclic(edges))
            System.out.println("Cycle found");
        else System.out.println("Cycle not found");
    }

    private static boolean isCyclic(int[][] edges) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
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
        Queue<Pair> q = new LinkedList<>();;
        q.add(new Pair(1,-1));
        isVisited[1] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i : adj.get(p.first)){
                if(isVisited[i] == 0){
                    isVisited[i] = 1;
                    q.add(new Pair(i, p.first));
                }
                else if(i != p.second){
                    return true;
                }
            }
        }
        return false;
    }

}
