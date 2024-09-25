import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid = new int[50][50];
    public static int[][] dp = new int[50][50];
    public static int ans = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++) for (int j=0; j<m; j++) grid[i][j] = sc.nextInt();

        dp[0][0] = 1;
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++){
                if (grid[i][j] <= grid[0][0]) continue;
                
                dp[i][j] = 2;
                for (int d=1; d<i; d++){
                    for (int q=1; q<j; q++){
                        if (grid[d][q] < grid[i][j]) {
                            dp[i][j] = Math.max(dp[d][q]+1, dp[i][j]);
                        }
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<m; j++) {
        //         System.out.printf("%d ", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        System.out.println(ans);
    }
}