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
            if (grid[i][1] > grid[0][0]) dp[i][1] = 2;
            else dp[i][1] = 0;
        }
        for (int j=2; j<n; j++) {
            if (grid[1][j] > grid[0][0]) dp[1][j] = 2;
            else dp[1][j] = 0;
        }

        for (int i=2; i<n; i++) {
            for (int j=2; j<n; j++){
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
        //     for (int j=0; j<n; j++) {
        //         System.out.printf("%d ", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        System.out.println(ans);
        // 여기에 코드를 작성해주세요.
    }
}