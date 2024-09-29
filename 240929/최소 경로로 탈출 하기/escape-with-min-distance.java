import java.util.*;

class Pair {
    int first, second;

    public Pair(int x, int y) {
        this.first = x; this.second = y;
    }
}
public class Main {
    public static int n, m;
    public static int[][] grid = new int[100][100];
    public static int[][] visited = new int[100][100];
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void bfs() {
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.first;
            int y = cur.second;

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] == 0 && grid[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                grid[i][j] = sc.nextInt();
        
        visited[0][0] = 1;
        q.add(new Pair(0, 0));
        bfs();
        System.out.print(visited[n-1][m-1]-1);
    }
}