// 240909 16:44 ~ 

import java.util.*;

public class Main {
    public static double n;
    public static int m, ans, ans_t;
    public static int[][] grid = new int[200][200];

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int[] length = new int[4];

    public static void melt(){
        // System.out.println(Math.ceil(n/2));

        for (int t=1; t<Math.ceil(n/2); t++) {
            int x = t; int y = t;

            int cnt = 0;
            if (grid[x][y] == 1) cnt++;

            for (int i = 0; i<4; i++){
                for (int j=1; j<length[i]; j++){
                    x += dx[i]; y += dy[i];
                    if (grid[x][y] == 1) cnt++;
                }
                length[i] -= 2;
            }
            // System.out.println(t);
            if (t == Math.ceil(n/2)-1) {
                ans = cnt;
                ans_t = t;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextDouble();
        m = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        length[0] = m - 2; length[1] = (int)(n - 2); length[2] = m - 2; length[3] = (int)(n - 2) - 1;
        melt();
        System.out.printf("%d %d", ans_t, ans);
        // 여기에 코드를 작성해주세요.
    }
}