// 24.09.08 23:27 ~ 

import java.util.*;

public class Main {
    public static int n, m, ans;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};
    public static int[][] grid = new int[100][100];

    public static void dfs(int x, int y){
        if (x == n-1 && y == m-1) ans = 1;
        if (ans == 1) return;
        
        for (int i=0; i<2; i++){
            int nx = x + dx[i]; int ny = y + dy[i];
            if (nx < n && ny < m && grid[nx][ny] == 1) dfs(nx, ny);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.print(ans);
    }
}