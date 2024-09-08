// 24.09.09 00:35 ~ 

import java.util.*;

public class Main {
    public static int n, max, cnt, tmp;
    public static int[][] grid = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y){
        visited[x][y] = true;
        tmp++;

        for (int i=0; i<4; i++){
            int nx = x + dx[i]; int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] != true && grid[x][y] == grid[nx][ny]) dfs(nx, ny);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) grid[i][j] = sc.nextInt();
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (!visited[i][j]) {
                    dfs(i, j);
                    max = Math.max(tmp, max);
                    if (tmp >= 4) cnt++;
                    tmp = 0;
                }
            }
        }

        System.out.printf("%d %d", cnt, max);
    }
}