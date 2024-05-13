package graph;

import java.util.LinkedList;
import java.util.Queue;

class FloodFill {
    public static void main(String[] args) {
        
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ic = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[][] isVisited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        image[sr][sc] = color;
        isVisited[sr][sc] = 1;
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int[][] aux = {{0,-1},{0,1},{-1,0},{1,0}};
            for(int i=0; i<4; i++){
                int[] t = aux[i];
                int r = p.first + t[0];
                int c = p.second + t[1];
                if(r>=0 && r<n && c>=0 && c<m && image[r][c] == ic && isVisited[r][c] == 0){
                    image[r][c] = color;
                    isVisited[r][c] = 1;
                    q.add(new Pair(r,c));
                }
            }
        }
        return image;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return '{'+ first +", " + second +'}';
    }
}
