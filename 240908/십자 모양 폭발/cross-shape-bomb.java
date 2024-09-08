import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid = new int[200][200];
    public static ArrayList[] new_grid = new ArrayList[200];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void bomb(int r, int c){
        int times = grid[r-1][c-1];
        grid[r-1][c-1] = 0;
        if (times != 1) {
            for (int i=0; i<4; i++){
                int nx = r-1; int ny = c-1;
                for (int j=0; j<times-1; j++){
                    nx += dx[i];
                    ny += dy[i];
                    if (inRange(nx, ny)) grid[nx][ny] = 0;
                }
            }
        }
    }

    public static void arrange(){
        // for (int i = 0; i < new_grid.length; i++) {
        //     new_grid[i] = new ArrayList();
        // }

        for (int j=0; j<n; j++){
            ArrayList tmp = new ArrayList();
            for (int i=0; i<n; i++){
                int num = grid[i][j];
                if (num == 0) continue;
                tmp.add(num);
            }
            int size = tmp.size();
            for (int i=0; i<n-size; i++) tmp.add(0, 0);
            new_grid[j] = tmp;
        }
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();

        bomb(r,c);
        arrange();
        
        for (int j=0; j<n; j++){
            for (int i=0; i<n; i++){
                System.out.printf("%d ", new_grid[i].get(j));
            }
            System.out.printf("\n");
        }
    }
}