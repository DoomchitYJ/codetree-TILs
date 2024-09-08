// 20:14 ~

import java.util.*;

public class Main {
    public static int n;
    public static int[][] origin = new int[50][50];
    public static int[][] grid = new int[50][50];
    public static int[][] tmp = new int[50][50];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n; 
    }
    public static void bomb(int x, int y) {
        int times = grid[x][y];
        grid[x][y] = 0;
        if (times == 1) return;

        for (int i=0; i<4; i++){
            int nx = x; int ny = y;
            for (int j=0; j<times-1; j++){
                nx += dx[i]; ny += dy[i];
                if (inRange(nx, ny)) grid[nx][ny] = 0;
            }
        }
    }
    public static void arrange(){
        for (int j=0; j<n; j++){
            int row = n-1;
            for (int i=n-1; i>=0; i--){
                if (grid[i][j] != 0){
                    tmp[row--][j] = grid[i][j];
                }
            }
        }
    }
    public static int find(){
        int cnt = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n-1; j++){
                int a = tmp[i][j]; int b = tmp[i][j+1];
                if (a != 0 && a == b) cnt++;
            }
        }
        for (int j=0; j<n; j++){
            for (int i=0; i<n-1; i++){
                int a = tmp[i][j]; int b = tmp[i+1][j];
                if (a != 0 && a == b) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                origin[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                // System.out.printf("%d, %d .. %d\n", i, j, i*n+j);
                
                for (int d=0; d<n; d++){
                    for (int q=0; q<n; q++){
                        grid[d][q] = origin[d][q];
                        tmp[d][q] = 0;
                    }
                } 
                bomb(i, j);
                arrange();
                max = Math.max(max, find());

                // for (int d=0; d<n; d++){
                //     for (int q=0; q<n; q++){
                //         System.out.print(tmp[d][q]+" ");
                //     }
                //     System.out.println();
                // } System.out.println();
            }
        }
        
        System.out.println(max);
    }
}