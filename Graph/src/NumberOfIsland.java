
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {

    public static void main(String[] args) {
        int[][] g = {
                {0,1,1,1,0},
                {0,1,1,0,0},
                {0,0,1,1,0},
                {0,0,0,0,0},
                {0,1,1,0,1}
        };
        int cnt = getIsland(g);
        System.out.println(cnt);
        
    }

    private static int getIsland(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int[][] isVisited = new int[n][m];
        int count = 0;
        for (int i=0; i<n; i++){
            for (int j = 0; j < m; j++) {
               if( g[i][j] == 1 && isVisited[i][j] == 0){
                   dfs(g,isVisited,i,j,m,n);
                   System.out.println("dfs" +i+" "+j);
                   //bfs(g,isVisited,i,j);
                   //System.out.println("bfs" +i+" "+j);
                   count++;
               }
            }
        }
        return count;
    }

    private static void dfs(int[][] g, int[][] isVisited, int i, int j, int m, int n) {
        System.out.println(i+" "+j);
        isVisited[i][j] = 1;
        for(int x=-1; x<=1; x++){
            for(int y=-1; y<=1; y++){
                int r = i + x;
                int c = j + y;
                if(r>=0 && r<n && c>=0 && c<m && g[r][c] == 1 && isVisited[r][c] == 0){
                    dfs(g,isVisited,r,c,m,n);
                }
            }
        }
    }

    private static void bfs(int[][] g, int[][] isVisited, int i, int j) {
        //System.out.println(i+" "+j);
        isVisited[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        int n = g.length;
        int m = g[0].length;
        while(!q.isEmpty()){
            Pair p = q.poll();
            System.out.println(p.first+" "+p.second);
            for(int x=-1; x<=1; x++){
                for(int y=-1; y<=1; y++){
                    int r = p.first + x;
                    int c = p.second + y;
                    if(r>=0 && r<n && c>=0 && c<m && g[r][c] == 1 && isVisited[r][c] == 0){
                        q.add(new Pair(r,c));
                        isVisited[r][c] = 1;
                    }
                }
            }
        }
    }
}
