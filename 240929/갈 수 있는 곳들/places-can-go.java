import java.util.*;

class Pair {
    int first, second;

    public Pair(int x, int y) {
        this.first = x; this.second = y;
    }
}
public class Main {
    public static final int MAX_NUM = 100;
    public static final int DIR_NUM = 4;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n, k, cnt;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    public static Queue<Pair> q = new LinkedList<>();

    public static void bfs() {
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.first; int y = cur.second;
            cnt++;
            // System.out.printf("%d , %d ... %d\n", x, y, cnt);

            for (int i=0; i<4; i++) {
                int nx = x + dx[i]; int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
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
        for (int i=0; i<n; i++) for (int j=0; j<n; j++) grid[i][j] = sc.nextInt();
        for (int i=0; i<k; i++) {
            int r = sc.nextInt() -1;
            int c = sc.nextInt() -1;
            
            if (!visited[r][c]) {
                visited[r][c] = true;
                q.add(new Pair(r, c));
                bfs();
            }
        }
        System.out.print(cnt);
    }
}