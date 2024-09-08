// 24.09.09 00:09 ~ 

import java.util.*;

public class Main {
    public static int n, m;
    public static int[] cnt = new int[101];
    public static int[][] grid = new int[50][50];
    public static boolean[][] visited = new boolean[50][50];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y, int k){
        if (grid[x][y] <= k) return;

        visited[x][y] = true;
        for (int i=0; i<4; i++){
            int nx = x + dx[i]; int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] != true) {
                dfs(nx, ny, k);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int max_k = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
                if (grid[i][j] > max_k) max_k = grid[i][j];
            }
        }

        for (int k=1; k<=max_k; k++){
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    if (!visited[i][j] && grid[i][j] > k) {
                        dfs(i, j, k);
                        cnt[k]++;
                    }
                }
            }
            visited = new boolean[50][50];
        }

        int ans = 0;
        int ans_cnt = 0;
        for (int i=1; i<=max_k; i++) {
            if (cnt[i] > ans_cnt) {
                ans = i;
                ans_cnt = cnt[i];
            }
        }

        System.out.printf("%d %d", ans, ans_cnt);
    }
}