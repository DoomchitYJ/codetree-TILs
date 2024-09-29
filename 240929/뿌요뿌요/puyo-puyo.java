import java.util.*;

public class Main {
    public static int n, cnt = 1;
    public static int[][] grid = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static ArrayList<Integer> arr_cnt = new ArrayList<>(); 

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && grid[x][y] == grid[nx][ny]) {
                cnt++;
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) for (int j=0; j<n; j++) grid[i][j] = sc.nextInt();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    if (cnt >= 4) arr_cnt.add(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.printf("%d %d", arr_cnt.size(), Collections.max(arr_cnt));
    }
}