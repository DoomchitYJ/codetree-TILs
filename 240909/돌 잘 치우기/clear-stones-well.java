// 240909 14:05 ~ 

import java.util.*;

class Pair {
    int first, second;

    public Pair(int x, int y){
        this.first = x;
        this.second = y;
    }
}
public class Main {
    public static int n, k, m, r, c, cnt;
    public static int[][] grid = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];

    public static ArrayList<Pair> stonePos = new ArrayList<>();
    public static ArrayList<Pair> selected = new ArrayList<>();

    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static ArrayList cnt_arr = new ArrayList();

    public static void bfs(){
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int x = cur.first; int y = cur.second;

            for (int i=0; i<4; i++){
                int nx = x + dx[i]; int ny = y + dy[i];

                if (0 <= nx && nx < n && 0<= ny && ny < n && visited[nx][ny] != true && grid[nx][ny] == 0){
                    // System.out.printf("gogo %d, %d ... \n", nx, ny);
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                    cnt++;
                }
            }
        }
        cnt_arr.add(cnt);
        cnt = 0;
    }
    public static void comb(int start, int num){
        if (num == 0) {
            // for (int i=0; i<m; i++) System.out.printf("%d, %d ", selected.get(i).first, selected.get(i).second);
            // System.out.println();

            for (int i=0; i<m; i++){
                Pair cur = selected.get(i);
                grid[cur.first][cur.second] = 0;
            }

            bfs();

            for (int i=0; i<m; i++){
                Pair cur = selected.get(i);
                grid[cur.first][cur.second] = 1;
            }
            visited = new boolean[100][100];
            q.add(new Pair(r, c));

            return;
        } else{
            for (int i=start; i<stonePos.size(); i++){
                selected.add(stonePos.get(i));
                comb(i+1, num-1);
                selected.remove(selected.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) stonePos.add(new Pair(i, j));
            }
        }
        for (int i=0; i<k; i++){
            r = sc.nextInt()-1;
            c = sc.nextInt()-1;
            q.add(new Pair(r, c));

            comb(0, m);
            stonePos = new ArrayList();
            selected = new ArrayList();
        }

        int max = 0;
        for (int i=0; i<cnt_arr.size(); i++){
            if ((int)cnt_arr.get(i) > max) max = (int)cnt_arr.get(i);
        }
        System.out.println(max);
        // 여기에 코드를 작성해주세요.
    }
}