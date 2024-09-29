import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static int[] dx ={-1, 1, 0, 0}; 
    public static int[] dy ={0, 0, -1, 1};
    public static Queue<Pair> q = new LinkedList<>();

    public static class Pair {
        int first, second;

        public Pair (int x, int y) {
            this.first = x; this.second = y;
        }
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Pair p = q.poll();

            int x = p.first;
            int y = p.second;
            visited[x][y] = true;

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && grid[nx][ny] == 1) {
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        q.add(new Pair(0, 0));
        visited[0][0] = true;
        bfs();

        if (visited[n-1][n-1]) System.out.print(1);
        else System.out.print(0);
    }
}