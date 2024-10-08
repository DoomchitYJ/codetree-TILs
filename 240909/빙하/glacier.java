// 240909 16:44 ~ 

import java.util.*;

public class Main {
    public static double n;
    public static int m;
    public static int[][] grid = new int[200][200];

    public static ArrayList ans = new ArrayList();
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int[] length = new int[4];

    public static void melt(){
        for (int t=1; t<Math.ceil(n/2); t++) {
            int x = t; int y = t;

            int cnt = 0;
            if (grid[x][y] == 1) cnt++;

            for (int i = 0; i<4; i++){
                for (int j=1; j<length[i]; j++){
                    x += dx[i]; y += dy[i];
                    if (grid[x][y] == 1) {
                        cnt++;
                        // System.out.printf("%d, %d...%d\n", x, y, cnt);
                    }
                }
                if (i<2 && length[i+1] == 1) break;
                length[i] -= 2;
            }
            // System.out.println(t);
            ans.add(cnt);
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

        for (int i=ans.size()-1; i>=0; i--){
            if ((int)ans.get(i) != 0) {
                System.out.printf("%d %d", i+1, ans.get(i));
                break;
            }
        }
    }
}