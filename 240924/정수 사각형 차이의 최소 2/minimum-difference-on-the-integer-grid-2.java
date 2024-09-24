import java.util.*;

public class Main {
    public static class Pair {
        public int first;
        public int second;

        public Pair (int x, int y) {
            this.first = x; this.second = y;
        }
    }
    public static int n;
    public static int[][] grid = new int[100][100];
    public static Pair[][] dp = new Pair[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) for (int j=0; j<n; j++) grid[i][j] = sc.nextInt();

        dp[0][0] = new Pair(grid[0][0], grid[0][0]);
        for (int i=1; i<n; i++) {
            dp[i][0] = new Pair(Math.max(dp[i-1][0].first, grid[i][0]), Math.min(dp[i-1][0].second, grid[i][0]));
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = new Pair(Math.max(dp[0][j-1].first, grid[0][j]), Math.min(dp[0][j-1].second, grid[0][j]));
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<n; j++) {
                // 위에서 내려온 경우
                int a = dp[i-1][j].first; int b = dp[i-1][j].second;
                Pair op1 = new Pair(0, 0);
                if (grid[i][j] > a) op1 = new Pair(grid[i][j], b);
                else if (grid[i][j] < b) op1 = new Pair(a, grid[i][j]);
                else op1 = new Pair(a, b);
                int num1 = op1.first - op1.second;

                // 왼쪽에서 넘어온 경우
                a = dp[i][j-1].first; b = dp[i][j-1].second;
                Pair op2 = new Pair(0, 0);
                if (grid[i][j] > a) op2 = new Pair(grid[i][j], b);
                else if (grid[i][j] < b) op2 = new Pair(a, grid[i][j]);
                else op2 = new Pair(a, b);
                int num2 = op2.first - op2.second;

                if (num1 < num2) dp[i][j] = op1;
                else dp[i][j] = op2;
            }
        }
        // for (int i=0; i<n; i++){
        //     for (int j=0; j<n; j++) {
        //         System.out.printf("(%d, %d) ", dp[i][j].first, dp[i][j].second);
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[n-1][n-1].first - dp[n-1][n-1].second);
    }
}