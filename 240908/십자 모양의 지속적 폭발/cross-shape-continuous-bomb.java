import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid = new int[200][200];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void print(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    public static void bomb(int col){
        for (int i=0; i<n; i++) {
            if (grid[i][col] == 0) continue;

            int times = grid[i][col];
            grid[i][col] = 0;   
            if (times == 1) break;

            for (int j=0; j<4; j++){
                int nx = i;
                int ny = col;
                
                for (int k=0; k<times-1; k++){
                    nx += dx[j];
                    ny += dy[j];
                    if (inRange(nx, ny)){
                        grid[nx][ny] = 0;
                    }
                }
            }
            break;
        }
    }
    public static void arrange(){
        for (int j=0; j<n; j++){
            for (int i=n-1; i>0; i--){
                if (grid[i][j] == 0){
                    grid[i][j] = grid[i-1][j];
                    grid[i-1][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<m; i++){
            int col = sc.nextInt()-1;
            bomb(col);
            arrange();
        }
        print();
    }
}