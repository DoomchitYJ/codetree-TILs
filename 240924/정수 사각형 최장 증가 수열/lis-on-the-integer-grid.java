import java.util.*;

public class Main {
    public static int n;
    public static long[][] grid = new long[500][500];
    public static int[][] dp = new int[500][500];
    public static boolean[][] visited = new boolean[500][500];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int gcnt = 0;

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && grid[nx][ny] > grid[x][y]) {
                if (visited[nx][ny] != true) dfs(nx, ny);
                dp[x][y] = Math.max(dp[x][y], dp[nx][ny]);
            }
        }
        dp[x][y]++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) 
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextLong();
            }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                gcnt = Math.max(gcnt, dp[i][j]);
            }
        }
        System.out.println(gcnt);
    }
}