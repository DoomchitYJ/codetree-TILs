// 240909 11:38 ~ 

import java.util.*;

class Pair {
    int first, second;

    public Pair (int x, int y){
        this.first = x;
        this.second = y;
    }
}

public class Main {
    public static int n, k, max, row, col, r, c;
    public static int[][] grid = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void bfs(){
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int x = cur.first; int y = cur.second;
            

            for (int i=0; i<4; i++){
                int nx = x + dx[i]; int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] != true && grid[nx][ny] < grid[r][c]) {
                    // System.out.printf("gogo %d, %d ... %d\n", nx, ny, grid[nx][ny]);
                    if (grid[nx][ny] > max) {
                        // System.out.printf("inside %d, %d ... %d\n", nx, ny, grid[nx][ny]);
                        max = grid[nx][ny];
                        row = nx; col = ny;
                        // System.out.printf("after %d, %d ... %d\n", row, col, max);
                    }
                    else if (grid[nx][ny] == max) {
                        // System.out.printf("inside %d, %d ... %d\n", nx, ny, grid[nx][ny]);
                        if (nx < row) {
                            row = nx; col = ny;
                            if (ny < col) col = ny;
                        }
                        else if (nx == row) {
                            col = Math.min(col, ny);
                        }
                        // System.out.printf("after %d, %d ... %d\n", row, col, max);
                    }

                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) grid[i][j] = sc.nextInt();
        }
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;

        for (int i=0; i<k; i++){
            visited[r][c] = true;
            q.add(new Pair(r, c));
            bfs();
            // System.out.printf("%d, %d ... %d\n", row, col, max);

            max = 0;
            r = row;
            c = col;
            visited = new boolean[100][100];
        }

        System.out.printf("%d %d", r+1, c+1);
    }
}