import java.util.*;

public class Main {
    public static int n;
    public static int[][] dp = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                dp[i][j] = sc.nextInt();
        }

        for (int i=1; i<n; i++){
            dp[i][n-1] += dp[i-1][n-1];
        }
        for (int j=n-2; j>=0; j--){
            dp[0][j] += dp[0][j+1];
        }

        for (int i=1; i<n; i++){
            for (int j=n-2; j>=0; j--)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + dp[i][j];
        }

        // for (int i=0; i<n; i++){
        //     for (int j=0; j<n; j++){
        //         System.out.printf("%d ", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[n-1][0]);
    }
}