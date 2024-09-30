import java.util.*;

class Pair {
    int first, second;

    public Pair(int x, int y) {
        this.first = x; this.second = y;
    }
}
public class Main {
    public static int n, r1, c1, r2, c2;
    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[][] visited = new int[100][100];
    public static Queue<Pair> q = new LinkedList<>();

    public static void bfs(){
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.first; int y = cur.second;
            for (int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new Pair(nx, ny));

                    if (nx == r2 && ny == c2) q.clear();
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;

        q.add(new Pair(r1, c1));
        visited[r1][c1] = 1;
        bfs();

        int ans = (visited[r2][c2] != 0) ? visited[r2][c2]-1 : -1;
        System.out.print(ans);
    }
}