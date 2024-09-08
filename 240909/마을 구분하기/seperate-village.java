// 24.09.08 23:50 ~

import java.util.*;

public class Main {
    public static int n, town, cnt;
    public static ArrayList ppl = new ArrayList();
    public static int[][] grid = new int[25][25];
    public static boolean[][] visited = new boolean[25][25];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y){
        cnt++;
        visited[x][y] = true;

        for (int i=0; i<4; i++){
            int nx = x + dx[i]; int ny = y + dy[i];
            if ((0 <= nx && nx < n && 0 <= ny && ny < n) && visited[nx][ny] != true && grid[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 0) visited[i][j] = true;
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (!visited[i][j]) {
                    town++;
                    dfs(i, j);
                    ppl.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(ppl);
        System.out.println(town);
        for (int i=0; i<town; i++) System.out.println(ppl.get(i));
        // 여기에 코드를 작성해주세요.
    }
}