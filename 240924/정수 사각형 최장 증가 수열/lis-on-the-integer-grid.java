import java.util.*;

public class Main {
    public static int n;
    public static long[][] grid = new long[500][500];
    public static boolean[][] visited = new boolean[500][500];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int gcnt = 0;

    public static void dfs(int x, int y, int cnt){
        visited[x][y] = true;
        gcnt = Math.max(gcnt, cnt);

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] != true && grid[nx][ny] > grid[x][y]) {
                // System.out.printf("%d, %d ... cnt = %d\n", nx, ny, cnt+1);
                dfs(nx, ny, cnt+1);
            } 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) 
            for (int j=0; j<n; j++) 
                grid[i][j] = sc.nextLong();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) dfs(i, j, 1);
                visited = new boolean[500][500];
                // System.out.println();
            }
        }
        System.out.println(gcnt);

        // 여기에 코드를 작성해주세요.
    }
}