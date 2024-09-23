import java.util.*;

public class Main {
    public static int n;
    public static int[][] dp = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n-1; i++) {
            dp[0][i] = Math.min(dp[0][i], dp[0][i+1]);
        }
        for (int i=0; i<n-1; i++) {
            dp[i][0] = Math.min(dp[i][0], dp[i+1][0]);
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<n; j++) {
                int a = Math.max(dp[i][j-1], dp[i-1][j]);
                if (dp[i][j] > a) dp[i][j] = a;
            }
        }

        System.out.println(dp[n-1][n-1]);
        // for (int i=0; i<n; i++){
        //     for (int j=0; j<n; j++) {
        //         System.out.printf("%d ", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        // 여기에 코드를 작성해주세요.
    }
}