import java.util.*;

class Pair {
    int first, second;

    public Pair() {}
    public Pair(int x, int y) {
        this.first = x; this.second = y;
    }
}
public class Main {
    public static int n, h, m;
    public static int[][] grid = new int[100][100];
    public static int[][] visited = new int[100][100];
    public static int[][] ans = new int[100][100];
    public static ArrayList<Pair> start = new ArrayList<Pair>();
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int bfs() {
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.first; int y = cur.second;

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0 && grid[nx][ny] != 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new Pair(nx, ny));

                    if (grid[nx][ny] == 3) {
                        q.clear();
                        return visited[nx][ny] - 1;
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++) 
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) start.add(new Pair(i, j));
            }
        
        for (int i=0; i<h; i++) {
            Pair cur = start.get(i);

            q.add(new Pair(cur.first, cur.second));
            visited[cur.first][cur.second]++;
            ans[cur.first][cur.second] = bfs();
            visited = new int[100][100];
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++)
                System.out.printf("%d ", ans[i][j]);
            System.out.println();
        }
    }
}