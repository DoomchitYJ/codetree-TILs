import java.util.*;

public class Main {
    public static int n;
    public static int[][] dp = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n; i++) 
            for (int j=0; j<n; j++) 
                dp[i][j] = sc.nextInt();

        for (int i=1; i<n; i++) dp[i][0] += dp[i-1][0];
        for (int j=1; j<n; j++) dp[0][j] += dp[0][j-1];
        
        for (int i=1; i<n; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + dp[i][j];
            }
        }

        System.out.print(dp[n-1][n-1]);
            // 여기에 코드를 작성해주세요.
    }
}